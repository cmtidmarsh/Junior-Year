import java.io.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Model extends UnicastRemoteObject implements ModelIntf, Serializable {
    int[][] currentGrid;
    int[][] nextGrid;
    HashMap<Integer, Pair<Integer, Integer>> players;
    PairFactory factory;

    public Model() throws RemoteException {
        super();
        this.currentGrid = new int[258][258];
        this.nextGrid = new int[258][258];
        this.players = new HashMap<Integer, Pair<Integer, Integer>>();
        this.factory = new PairFactory();
    }


    public HashMap<Integer, Pair<Integer, Integer>> getPlayerPositions(int except) throws RemoteException {
        if (except == -1) { this.players.put(this.players.size(), this.factory.createPair(null, 0,0)); }
        return this.players;
    }

    public void sendPlayerPosition(int playerID, int positionX, int positionY) throws RemoteException {
        this.players.replace(playerID, this.factory.createPair(this.players.get(playerID), positionX, positionY));
    }

    public int gatherResources(int forPlayer) throws RemoteException {
        return 0;
    }

    public void updateResources() throws RemoteException {
        double g = 1.1;
        for(int i = 1; i < 257; i++) {
            for(int j = 1; j < 257; j++) {
                int aliveNeighbors = 0;
                if (this.currentGrid[i-1][j-1] > 0) {aliveNeighbors++;}
                if (this.currentGrid[i-1][j] > 0) {aliveNeighbors++;}
                if (this.currentGrid[i-1][j+1] > 0) {aliveNeighbors++;}
                if (this.currentGrid[i][j-1] > 0) {aliveNeighbors++;}
                if (this.currentGrid[i][j+1] > 0) {aliveNeighbors++;}
                if (this.currentGrid[i+1][j-1] > 0) {aliveNeighbors++;}
                if (this.currentGrid[i+1][j] > 0) {aliveNeighbors++;}
                if (this.currentGrid[i+1][j+1] > 0) {aliveNeighbors++;}
                double p = g*aliveNeighbors/8;
                double rand = Math.random();
                if (rand < p) {
                    if (this.currentGrid[i][j] != 7) {
                        this.nextGrid[i][j] = this.currentGrid[i][j] + 1;
                    }
                } else {
                    this.nextGrid[i][j] = this.currentGrid[i][j];
                }
            }
        }
        for(int i = 0; i < 258; i++) {
            for(int j = 0; j < 258; j++) {
                this.currentGrid[i][j] = this.nextGrid[i][j];
            }
        }
    }

    public int[][] getResources() throws RemoteException {
        return this.currentGrid;
    }

    public void readInput(String str) throws IOException {
        FileInputStream in = new FileInputStream(str);
        BufferedReader br = new BufferedReader((new InputStreamReader(in)));
        String currentLine = br.readLine();
        int lineNumber = 1;
        while(currentLine!=null) {
            for(int i = 1; i < 257; i++) {
                this.currentGrid[lineNumber][i] = Character.getNumericValue(currentLine.charAt(i-1));
            }
            lineNumber++;
            currentLine = br.readLine();
        }
    }

    public static void main(String[] args) {

        try {
            // Create a WeatherServer object and announce its service to the
            // registry.
            Model Model = new Model();
            Naming.rebind("/Model", Model);
            Model.readInput("Input.txt");
            System.out.println("Server running");
            TimeUnit.SECONDS.sleep(15);
            while (true) {
                Model.updateResources();
                TimeUnit.SECONDS.sleep(5);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}