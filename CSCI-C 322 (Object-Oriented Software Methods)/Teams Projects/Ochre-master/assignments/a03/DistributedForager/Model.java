import java.io.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Model extends UnicastRemoteObject implements ModelIntf, Serializable {
    int[][] currentGrid;
    int[][] nextGrid;
    HashMap<Integer, Pair<Integer, Integer>> players;
    boolean gameStarted;
    int startingState;
    int gameClock;

    public Model() throws RemoteException {
        super();
        this.currentGrid = new int[258][258];
        this.nextGrid = new int[258][258];
        this.players = new HashMap<Integer, Pair<Integer, Integer>>();
        this.gameStarted = false;
        this.startingState = 1;
        this.gameClock = 0;
    }


    public HashMap<Integer, Pair<Integer, Integer>> getPlayerPositions(int except) throws RemoteException {
        if (except == -1) { this.players.put(this.players.size(), new Pair<Integer, Integer>(50, 50)); }
        return this.players;
    }

    public void sendPlayerPosition(int playerID, int positionX, int positionY) throws RemoteException {
        if(gameStarted) {
            this.players.replace(playerID, new Pair<Integer, Integer>(this.players.get(playerID).getX() + positionX, this.players.get(playerID).getY() + positionY));
        } else if (gameClock == 0) {
            if (positionX == 1) {
                this.buildBoard(this.startingState);
                gameStarted = true;
                this.currentGrid[0][0] = 2;
            } else if (positionX == 2) {
                startingState = 1;
            } else if (positionX == 3) {
                startingState = 2;
            } else if (positionX == 4) {
                startingState = 3;
            }
        }
    }

    public int gatherResources(int forPlayer) throws RemoteException {
        int x = (this.players.get(forPlayer).getX()+10) / 10;
        int y = (this.players.get(forPlayer).getY()-10) / 10;
        int score_added = this.currentGrid[x][y];
        this.currentGrid[x][y] = 0;
        return score_added;
    }

    public void updateResources() throws RemoteException {
        if (gameStarted) {
            double g = 1.4;
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
            gameClock++;
            if (gameClock > 72) {
                gameStarted = false;
                this.currentGrid[0][0] = 1;
            }
        }
    }

    public int[][] getResources() throws RemoteException {
        return this.currentGrid;
    }

    public void buildBoard(int state) {
        int clusterOneX = ThreadLocalRandom.current().nextInt(1,164);
        int clusterOneY = ThreadLocalRandom.current().nextInt(1,164);
        int clusterTwoX = ThreadLocalRandom.current().nextInt(1,164);
        int clusterTwoY = ThreadLocalRandom.current().nextInt(1,164);
        if (state == 1) {
            for (int i = clusterOneX; i < clusterOneX+90; i++) {
                for (int j = clusterOneY; j < clusterOneY+90; j++) {
                    this.currentGrid[i][j] = ThreadLocalRandom.current().nextInt(0,8);
                }
            }
            for (int i = clusterTwoX; i < clusterTwoX+90; i++) {
                for (int j = clusterTwoY; j < clusterTwoY+90; j++) {
                    this.currentGrid[i][j] = ThreadLocalRandom.current().nextInt(0,8);
                }
            }
        } else if (state == 2) {
            for (int i = clusterOneX; i < clusterOneX+90; i++) {
                for (int j = clusterOneY; j < clusterOneY+90; j++) {
                    this.currentGrid[i][j] = ThreadLocalRandom.current().nextInt(0,8);
                }
            }
            for (int i = clusterTwoX; i < clusterTwoX+90; i++) {
                for (int j = clusterTwoY; j < clusterTwoY+90; j++) {
                    this.currentGrid[i][j] = ThreadLocalRandom.current().nextInt(0,5);
                }
            }
        } else {
            for (int i = clusterOneX; i < clusterOneX+90; i++) {
                for (int j = clusterOneY; j < clusterOneY+90; j++) {
                    this.currentGrid[i][j] = ThreadLocalRandom.current().nextInt(0,8);
                }
            }
            for (int i = clusterTwoX; i < clusterTwoX+90; i++) {
                for (int j = clusterTwoY; j < clusterTwoY+90; j++) {
                    this.currentGrid[i][j] = ThreadLocalRandom.current().nextInt(0,3);
                }
            }
        }
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
        System.setSecurityManager(new SecurityManager());

        try {
            Model Model = new Model();
            Naming.rebind("/Model", Model);
            System.out.println("Server running");
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