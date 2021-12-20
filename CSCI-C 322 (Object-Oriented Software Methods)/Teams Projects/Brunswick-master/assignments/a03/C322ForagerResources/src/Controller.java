import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.*;

public class Controller extends Observable {

    private ArrayList<Observer> observers = new ArrayList<>();
    private View view;
    private ForagerIntf server;
    private int[][] board;
    private Player player;
    private HashMap<Integer, Pair<Integer, Integer>> otherPlayerPositions;

    public Controller(ForagerIntf server, int playerColor) throws RemoteException {

        this.server = server;
        this.otherPlayerPositions = server.getPlayerPositions(-1); // -1 cannot be a player id,
        // therefore we will get the list of all of the players
        this.board = server.getResources();
        createNewPlayer(otherPlayerPositions, playerColor);
        this.view = new View(this, this.player, this.board, this.otherPlayerPositions);
    }

    private void createNewPlayer(HashMap<Integer, Pair<Integer, Integer>> otherPlayerPositions, int playerColor) {

        int maxID = 0;
        for (Integer i : otherPlayerPositions.keySet()) maxID = i > maxID ? i : maxID;

        // TODO make random location
        Random r = new Random();

        this.player = new ConcretePlayer(r.nextInt(Integer.MAX_VALUE), 10, 10);
        switch (playerColor) {
            case 1:
                this.player = new YellowPlayer(this.player);
                break;
            case 2:
                this.player = new GreenPlayer(this.player);
                break;
            case 3:
                this.player = new BluePlayer(this.player);
                break;
        }
    }

    public void addObserver(Observer o) {
        super.addObserver(o);
        this.observers.add(o);
    }

    public void removeObserver(Observer o) {
        super.deleteObserver(o);
        this.observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this, new ThreePair<>(this.player, this.board, this.otherPlayerPositions));
        }
    }

    private void communicateWithServer() throws RemoteException {

        // need to: possibly gather resources, get the new board

        sendCurrentLocation();
        updateBoard();
        notifyObservers();
        getOtherPlayersLoc();
        gatherResources();
    }

    private void sendCurrentLocation() throws RemoteException {

        int playerX = player.getPosition().getFirst();
        int playerY = player.getPosition().getSecond();

        // Update the Player's location
        server.sendPlayerPosition(player.getId(), playerX, playerY);
    }

    private void gatherResources() throws RemoteException {

        int playerX = player.getPosition().getFirst();
        int playerY = player.getPosition().getSecond();

        if (board[playerY][playerX] != 0) {
            // Ask the server to gather the resources the player is standing on
            player.addResources(server.gatherResource(player.getId()));
        }
    }

    private void updateBoard() throws RemoteException {
        // Actual implementation
        this.board = server.getResources();

        // WE CHANGED THIS
        this.otherPlayerPositions = server.getPlayerPositions(player.getId());
    }

    private void getOtherPlayersLoc() throws RemoteException {
        this.otherPlayerPositions = server.getPlayerPositions(this.player.getId());
    }

    public static void main(String[] args) throws RemoteException {

        try {
            ForagerIntf GameServer = (ForagerIntf) Naming.lookup("//localhost/ForagerGame");


            Scanner scanner = new Scanner(System.in);
            System.out.print("Type the number for your preferred player color:\n1) Yellow\n2) " +
                            "Green\n3) Blue\n\n");
            Controller controller = new Controller(GameServer, scanner.nextInt());


            Thread t = new Thread();
            while (true) {

                try {
                    t.sleep(100);
                    controller.communicateWithServer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) { e.printStackTrace(); }

    }

    // Testing
//    private Controller() {
//
//        HashMap<Integer, Pair<Integer, Integer>> testPlayers = new HashMap<>();
//        testPlayers.put(0, new Pair<>(1, 1));
//        testPlayers.put(1, new Pair<>(5, 5));
//        testPlayers.put(2, new Pair<>(100, 100));
//        testPlayers.put(3, new Pair<>(250, 240));
//        testPlayers.put(4, new Pair<>(69, 96));
//        this.otherPlayerPositions = testPlayers;
//
//        this.board = new int[256][256];
//        try {
//
//            Scanner sc = new Scanner(new File("C:\\Users\\dylan\\Documents\\C322\\Brunswick\\assignments\\a02\\C322ForagerResources\\initial-board.txt"));
//            for (int i = 0; i < 256; i++) {
//                String line = sc.nextLine();
//                for (int j = 0; j < 256; j++) {
//                    board[i][j] = Character.getNumericValue(line.charAt(j));
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.err.println("FileNotFoundException: initial-board.txt cannot be opened");
//        }
//
//        this.player = new GreenPlayer(new ConcretePlayer(0, 126, 126));
//
//        this.view = new View(this, this.player, this.board, this.otherPlayerPositions);
//    }
//    public static void main(String[] args) throws RemoteException {
//
//        Controller controller = new Controller();
//
//        Thread t = new Thread();
//        while (true) {
//
//            try {
//                t.sleep(100);
//                controller.communicateWithServer();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
}
