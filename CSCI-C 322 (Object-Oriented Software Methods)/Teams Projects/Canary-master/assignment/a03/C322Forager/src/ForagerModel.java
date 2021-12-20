import javax.swing.Timer;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class ForagerModel extends UnicastRemoteObject implements ForagerInterface, Serializable {

    private int[][] board;
    private ArrayList<Player> players;

    ForagerModel(int[][] board) throws RemoteException
    {
        this.board = board;
        players = new ArrayList<>();
    }

    @Override
    public HashMap<Integer, Pair<Integer, Integer>> getPlayerPositions(int except) throws RemoteException {
        HashMap<Integer, Pair<Integer, Integer>> playerPositions = new HashMap();
        for (Player player : players)
        {
            int id = player.getID();
            if (id != except) {
                Pair<Integer, Integer>  positions = player.getPosition();
                playerPositions.put(id, positions);
            }
        }
        return playerPositions;
    }

    @Override
    public void sendPlayerPosition(int playerID, int positionX, int positionY) throws RemoteException {
        Player player = null;
        boolean inList = false;
        for (Player p : players)
        {
            if (p.getID() == playerID)
            {
                player = p;
                inList = true;
            }


        }

        if (!inList)
        {
            // its never actually adding the player based on their id. it is always random. need some way of setting the id number in the model.
            Player newPlayer = new Player(positionX, positionY, 0);
            newPlayer.setID(playerID);
            players.add(newPlayer);
        }

        if (player != null)
        {
            player.setPosition(positionX, positionY);
            players.remove(player);
            players.add(player);
        }
    }

    @Override
    public int gatherResource(int forPlayer) throws RemoteException {
        Player player = null;

        for (Player p : players)
        {
            System.out.println(p.getID());
            if (p.getID() == forPlayer) player = p;
        }

        if (player != null)
        {
            // getting players position
            Pair<Integer, Integer>  position = player.getPosition();
            int x = (int) position.getFirst();
            int y = (int) position.getSecond();

            //if there is a player there (also makes sure that it cannot go below 10. this makes sure that the player position shows up on the view.

            if(board[x][y] > 0){

                player.setResources(player.getResources() + board[x][y]);
                board[x][y] = 0;
            }
            return board[x][y];
        }

        return 0;
    }

    @Override
    public void updateResources() throws RemoteException {
        double g = .01;
        int timer = 10;

        /*
        for (Player p: players){
            gatherResource(p.getID());
        }


         */
        for (int i = 0; i < board[0].length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                if (board[i][j] != 9) {
                    int resource = board[i][j];
                    int numOfAlive = 0;
                    try {
                        if (board[i + 1][j] > 0) numOfAlive++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }

                    try {
                        if (board[i - 1][j] > 0) numOfAlive++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }

                    try {
                        if (board[i][j + 1] > 0) numOfAlive++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }

                    try {
                        if (board[i][j - 1] > 0) numOfAlive++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }

                    double threshold = g * ((numOfAlive * timer - 1) / 4);
                    double rand = Math.random();
                    if (rand < threshold) {
                        resource += 1;
                    }
                    if (resource > 7) {
                        resource -= 1;
                    }
                    board[i][j] = resource;
                }
            }
        }
    }

    @Override
    public int[][] getResources() throws RemoteException {
        return board;
    }

    @Override
    public void setResources(int[][] resources) throws RemoteException {
        this.board = resources;
    }


    // new helper function for building the initial game board.
    public void initialBoardSetup(int[][] board){
        Scanner s = new Scanner(System.in);

        // getting input from the admin
        System.out.println("please enter the location of the first cluster of resources.");
        System.out.println("First X: ");
        int xOne = s.nextInt();
        System.out.println("First Y");
        int yOne = s.nextInt();

        System.out.println("please enter the location of the second cluster of resources.");
        System.out.println("Second X: ");
        int xTwo = s.nextInt();
        System.out.println("Second Y");
        int yTwo = s.nextInt();

        System.out.println("Location of first cluster: ("+ String.valueOf(xOne)+ ","+ String.valueOf(yOne)+")");
        System.out.println("Location of second cluster: ("+ String.valueOf(xTwo)+ ","+ String.valueOf(yTwo)+")");

        System.out.println("Please enter the percentage of resources in the first cluster");
        int clusterOnePercentage = s.nextInt();

        int clusterTwoPercentage = 100-clusterOnePercentage;


        //Distribute Board - 1st cluster
        Random random = new Random();
        for(int i = xOne-(clusterOnePercentage/2); i < xOne+(clusterOnePercentage/2); i++){
            for(int j = yOne-(clusterOnePercentage/2); j < yOne+(clusterOnePercentage/2); j++){
                int trueI = i;
                int trueJ = j;

                if(i >= board.length){ trueI = board.length-1; }
                if (i < 0){ trueI = 0;}

                if(j >= board.length){ trueJ = board.length-1;}
                if(j < 0 ){ trueJ = 0; }

                board[trueI][trueJ] = random.nextInt(7);
            }
        }

        //Distribute Board - 2nd cluster
        for(int i = xTwo-(clusterTwoPercentage/2); i < xTwo+(clusterTwoPercentage/2); i++){
            for(int j = yTwo-(clusterTwoPercentage/2); j < yTwo+(clusterTwoPercentage/2); j++){
                int trueI = i;
                int trueJ = j;

                if(i >= board.length){ trueI = board.length-1; }
                if (i < 0){ trueI = 0;}

                if(j >= board.length){ trueJ = board.length-1;}
                if(j < 0 ){ trueJ = 0; }

                board[trueI][trueJ] = random.nextInt(7);
            }
        }
        this.board = board;

    }


    public static void main(String[] args) throws RemoteException {
        int[][] board = new int[100][100];

        ForagerModel m = new ForagerModel(board);
        m.initialBoardSetup(board);
        try {
            Naming.rebind("/Model", m);
            System.out.println("Succesfully rebound name");
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("here's the exception- main");
        }

        Thread t = new Thread();
        while (true) {

            m.updateResources();
            try {
                t.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}