import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Model implements ForagerInterface {
    public static int BOARDSIZE = 50;
    int size = 16;
    int id = 1;
    ArrayList<ArrayList<Tile>> board = new ArrayList<ArrayList<Tile>>();
    int[][] cellArray = new int[BOARDSIZE][BOARDSIZE];
    ArrayList<Player> players = new ArrayList<Player>();
    Random rn = new Random();



    public Model() { // Fill array with empty Tiles
        for (int i = 0; i < BOARDSIZE; i++) {
            ArrayList<Tile> row = new ArrayList<Tile>();
            for (int j = 0; j < BOARDSIZE; j++) {
                Tile t = new Tile(i, j);
                row.add(t);
            }
            board.add(row);
        }
    }

    public int getAdjCells(int i, int j) {
        if (i == 0 && j == 0) {
            return 2;
        }
        else if (i == size-1 && j == size-1) {
            return 2;
        }
        else if (i == 0 || j == 0) {
            return 3;
        }
        else {
            return 4;
        }
    }

    public float prob(float g, int adj) {
        float n = (float) adj;
        return g * (n / 4);
    }

    public void update() {
        for(ArrayList<Tile> tiles: board){
            for(Tile tile: tiles){
                cellArray[tile.positionX][tile.positionY] = tile.state;
            }
        }

        updateResources();
    }

    // public void updatePlayerPositions() {
    //     for (Player p : players) {
    //         Tile t = this.board.get(p.positionX).get(p.positionY);
    //         gatherResource(p, t);
    //     }
    // }


    // public void gatherResource(Player p, Tile t) {
    //     p.collectedResources += t.state;
    //     t.state = 0;
    // }



/*
//    //read in starting ASCII file
//    public void readIn(String path) throws FileNotFoundException {
//        File file = new File(path);
//
//        Scanner scanner = new Scanner(file);
//        String input = scanner.useDelimiter("\\Z").next();
//
//        char[] chArray = input.toCharArray();
//
//        int j = 0;
//        for( int i=0; i<chArray.length; i++ ){
//            if (chArray[i] != '\n')
//                chArray[j++] = chArray[i];
//        }
//        char[] newArray = new char[j];
//        System.arraycopy( chArray, 0, newArray, 0, j );
//
//        int c = 0;
//        for(int i=0; i<cellArray[0].length; i++) {
//            for(int k=0; k<cellArray.length; k++) {
//                cellArray[i][k] = Character.getNumericValue(newArray[c++]);
//            }
//        }
//    }
*/

    //    @Override
   public HashMap<Integer, Pair<Integer, Integer>> getPlayerPositions(int except) throws RemoteException {
        HashMap<Integer,  Pair<Integer, Integer>> hash_map = new HashMap<Integer,  Pair<Integer, Integer>>();
        for(Player p: players){
            if(p.getID() != except) {
                Pair<Integer, Integer> par = new Pair(p.positionX,p.positionY);
                hash_map.put(p.getID(), par);
            }
        }
        return hash_map;
   }

    @Override
    public void sendPlayerPosition(int playerID, int positionX, int positionY) throws RemoteException {
        for(Player p: players){
            if(p.getID() == playerID) {
                p.setPosition(positionX,positionY);
                break;
            }
        }
    }

    @Override
    public int gatherResource(int forPlayer) throws RemoteException {
        for(Player p: players){
            if(p.getID() == forPlayer) {
                int temp = board.get(p.positionX).get(p.positionY).state;
                board.get(p.positionX).get(p.positionY).state = 0;
                return temp;
            
            }
        }
        return 0;
    }

    @Override
    public void updateResources () {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(0).size(); j++) {

                float rnFloat = rn.nextFloat();
                float probability = prob(.0000000001f, getAdjCells(i, j));
                Tile currentCell = board.get(i).get(j);

                if (probability >= rnFloat && currentCell.state < 7) {
                    currentCell.state += 1;
                }
            }
        }
        for(ArrayList<Tile> tiles: board){
            for(Tile tile: tiles){
                cellArray[tile.positionX][tile.positionY] = tile.state;
            }
        }
    }

    @Override
    public int[][] getResources() throws RemoteException {
        return cellArray;
    }

    @Override
    public void printMsg() throws RemoteException {
        System.out.println("Players connected");
        for(Player p : players){
            System.out.println(p.getID());
        }
    }


    public static void main(String args[]) {
        try {
            // Instantiating the implementation class
            Model obj = new Model();

            // Exporting the object of implementation class
            // (here we are exporting the remote object to the stub)
            ForagerInterface stub = (ForagerInterface) UnicastRemoteObject.exportObject(obj, 0);

            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Hello", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
