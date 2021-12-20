import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ForagerGame extends UnicastRemoteObject implements ForagerIntf {

    public HashMap<Integer, Player> players = new HashMap<>();
    private ArrayList<Cell> resources = new ArrayList<>();
    public int[][] resourceBoard = new int[256][256];

    public ForagerGame() throws RemoteException {
//        this.timer = new Timer();
        // read in the initial-board
        readCells();
        createCells();
    }

    public void readCells() throws RemoteException {

        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("If you want to start the game with a 50/50 distribution enter '1', 65/35 enter '2', and 80/20 enter '3'");
            int choice = scanner.nextInt();
            Scanner sc = new Scanner(new File("H:\\Documents\\C322\\Brunswick\\assignments\\a03\\C322ForagerResources\\initial-board.txt"));
            if(choice == 1){
                sc = new Scanner(new File("H:\\Documents\\C322\\Brunswick\\assignments\\a03\\C322ForagerResources\\initial-board5050.txt"));
            }
            else if(choice == 2){
                sc = new Scanner(new File("H:\\Documents\\C322\\Brunswick\\assignments\\a03\\C322ForagerResources\\initial-board6535.txt"));
            }
            else{
                sc = new Scanner(new File("H:\\Documents\\C322\\Brunswick\\assignments\\a03\\C322ForagerResources\\initial-board8020.txt"));
            }

            for (int i = 0; i < 256; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < 256; j++) {
                    resourceBoard[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: initial-board.txt cannot be opened");
        }
    }
    
    public void createCells() throws RemoteException {

        for(int i = 0; i < resourceBoard.length; i++) {
            for(int j = 0; j < resourceBoard[i].length; j++) {
                resources.add(new Cell(resourceBoard[j][i], i, j));
            }
        }
    }

    public HashMap<Integer, Pair<Integer, Integer>> getPlayerPositions(int except) throws RemoteException {

        HashMap<Integer, Pair<Integer, Integer>> playerInfo = new HashMap<>();

        for(Integer id : players.keySet()) {

            Player curPlayer = players.get(id);
            if (curPlayer.getId() != except) {
                playerInfo.put(curPlayer.getId(), curPlayer.getPosition());
            }
        }
        return playerInfo;
    }

    public void sendPlayerPosition(int playerID, int positionX, int positionY) throws RemoteException {

        if (players.containsKey(playerID)) { // if a player has already communicated before
            Player curPlayer = players.get(playerID);
            curPlayer.setPosition(positionX, positionY);
        }
        else { // the first time a player is sending their info

            players.put(playerID, new Player(playerID, positionX, positionY));
        }
    }

    public int gatherResource(int forPlayer) throws RemoteException {

        // Find the player asking for the resource and get their position
        Player currentPlayer = players.get(forPlayer);
        Pair<Integer, Integer> currentPosition = currentPlayer.getPosition();
        int playerX = currentPosition.getFirst();
        int playerY = currentPosition.getSecond();
        int numOfResources = resourceBoard[playerX][playerY];

        // Give the player the number of resources at the specified location and revert the
        // location to 0 resource
        currentPlayer.addResources(numOfResources);
        resourceBoard[playerY][playerX] = 0;
        for(int i = 0; i < resources.size(); i++){
            if(resources.get(i).getX() == playerY && resources.get(i).getY() == playerX){
                resources.get(i).setResourceLevel(0);
            }
        }
        return numOfResources;
    }

    public void updateResources() throws RemoteException{
        int[][] newResources = new int[256][256];

        for (int i = 0; i < resources.size(); i++) {
            int x = i/256;
            int y = i%256;
            int cellResourceLevel = resources.get(i).update(resourceBoard);
            newResources[x][y] = cellResourceLevel;
        }
        resourceBoard = newResources;
    }

    public int[][] getResources() throws RemoteException {
        return resourceBoard;
    }

    public static void main(String[] args) {

        System.setSecurityManager(new SecurityManager());

        try {

            ForagerGame foragerGame = new ForagerGame();
            Naming.rebind("/ForagerGame", foragerGame);
            long startTime = System.nanoTime();
            long endTime;
            long timeElapsed = 0;

            Thread t = new Thread();
            while (timeElapsed < 360) {
                endTime = System.nanoTime();
                timeElapsed = (endTime - startTime)/1000000000;
                System.out.println("Time Elapsed: " + Long.toString(timeElapsed));
                foragerGame.updateResources();
                t.sleep(300);
            }
            System.out.println("Game Over, Restart to Play Again");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
