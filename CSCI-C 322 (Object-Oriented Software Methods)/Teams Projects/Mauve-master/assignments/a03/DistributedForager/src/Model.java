import java.io.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
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

    // Generates a random Integer between 0 and Integer.MAX_VALUE, checks if it's used, and creates a new integer if it is not unique
    public int generatePlayerID() throws RemoteException {

        Random r = new Random();
        int generatedID = r.nextInt();
        while (players.containsKey(generatedID)) generatedID = r.nextInt();

        players.put(generatedID, new Pair<>(50,50));

        return generatedID;
    }

    public HashMap<Integer, Pair<Integer, Integer>> getPlayerPositions(int except) throws RemoteException {
        if (except == -1) { this.players.put(this.players.size(), this.factory.createPair(null, 0,0)); }
        return this.players;
    }

    public void sendPlayerPosition(int playerID, int positionX, int positionY) throws RemoteException {
        // First 6 lines of code prohibit the player from going out of bounds
        int currentPositionX = this.players.get(playerID).getX();
        int currentPositionY = this.players.get(playerID).getY();
        int possiblePositionX = positionX;
        int possiblePositionY = positionY;

        if ((currentPositionX == 0 && positionX == -10) || (currentPositionX == 2550 && positionX == 10)) possiblePositionX = 0;
        if ((currentPositionY == 0 && positionY == -10) || (currentPositionY == 2550 && positionY == 10)) possiblePositionY = 0;

        // Remaining code in this function checks if a pair at the desired player location already exists and prohibits them from moving into that location if so
        Pair newPosition = this.factory.createPair(this.players.get(playerID), possiblePositionX, possiblePositionY);
        boolean found = false;
        for (int i : this.players.keySet()){
            int newX = this.players.get(i).getX();
            int newY = this.players.get(i).getY();
            if (newX == (int)newPosition.getX() && newY == (int)newPosition.getY()) {
                found = true;
            }
        }
        if (!found){
            this.players.replace(playerID, newPosition);
        }
    }

    public int gatherResources(int forPlayer) throws RemoteException {
        // Gets the location of where the player is and removes 1 resource from the 2D array at that location, then returns 1 resource for updating client's score
        int xPos = this.players.get(forPlayer).getX();
        int yPos = this.players.get(forPlayer).getY();
        int retVal = 0;
        if (this.currentGrid[(xPos/10) + 1][(yPos/10) + 1] > 0) {
            this.currentGrid[(xPos/10) + 1][(yPos/10) + 1] -= 1;
            retVal = 1;
        }
        return retVal;
    }

    private void updateResources() throws RemoteException {
        // This uses the same implementation from previous team but has been slightly updated to run faster
        // g rate is very low because the server updates the board every 50 milliseconds
        this.nextGrid = this.currentGrid;
        double g = .0155;
        for(int i = 1; i < 257; i++) {
            for(int j = 1; j < 257; j++) {
                if (this.currentGrid[i][j] < 7) {
                    int aliveNeighbors = 0;
                    if (this.currentGrid[i - 1][j - 1] > 0) { aliveNeighbors++; }
                    if (this.currentGrid[i - 1][j] > 0) { aliveNeighbors++; }
                    if (this.currentGrid[i - 1][j + 1] > 0) { aliveNeighbors++; }
                    if (this.currentGrid[i][j - 1] > 0) { aliveNeighbors++; }
                    if (this.currentGrid[i][j + 1] > 0) { aliveNeighbors++; }
                    if (this.currentGrid[i + 1][j - 1] > 0) { aliveNeighbors++; }
                    if (this.currentGrid[i + 1][j] > 0) { aliveNeighbors++; }
                    if (this.currentGrid[i + 1][j + 1] > 0) { aliveNeighbors++; }

                    double p = g * aliveNeighbors / 8;
                    double rand = Math.random();
                    if (rand < p) {
                        this.nextGrid[i][j] = this.currentGrid[i][j] + 1;

                    }
                }
            }
        }
        this.currentGrid = this.nextGrid;
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
        System.setSecurityManager(new SecurityManager());

        try {
            // Create a WeatherServer object and announce its service to the
            // registry.
            Model Model = new Model();
            Naming.rebind("/Model", Model);int x1 = 0;
            int x2 = 0;
            int y1 = 0;
            int y2 = 0;
            double pc1 = 0;
            double pc2 = 0;

            System.out.println("Server running");
            Scanner sc = new Scanner(System.in);

            // The x and y coords are flipped, these next 8 lines are correct and work
            System.out.println("\nEnter the X coordinate for the first circle of resources (25 for board resources to fully fill in 5 minutes): ");
            y1 = sc.nextInt();
            System.out.println("\nEnter the Y coordinate for the first circle of resources (25 for board resources to fully fill in 5 minutes): ");
            x1 = sc.nextInt();
            System.out.println("\nEnter the X coordinate for the second circle of resources (125 for board resources to fully fill in 5 minutes): ");
            y2 = sc.nextInt();
            System.out.println("\nEnter the Y coordinate for the second circle of resources (50 for board resources to fully fill in 5 minutes): ");
            x2 = sc.nextInt();
            System.out.println("\nEnter the percentage of resources for the first circle (50 for board resources to fully fill in 5 minutes): ");
            pc1 = sc.nextInt();
            pc2 = 100 - pc1;

            if (x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0 || x1 > 255 || x2 > 255 || y1 > 255 || y2 > 255) {
                System.out.println("Make sure the coordinates are between 0 and 255. Restart the server and try again");
            } else if (pc1 < 1 || pc1 > 99) {
                System.out.println("Make sure the percentage is between 1 and 99. Restart the server and try again");
            } else {
                FileWriter write = new FileWriter("Input.txt");

// 7*pc1 and 7*pc2 to get value of resource. Each resource is 42 circles. 12 long and 7 tall.
                int [][] input= new int[257][257];
                for (int q = 0; q < 257; q++) {
                    for (int w = 0; w < 257; w++) {
                        input[q][w]=0;
                    }
                }
                for (int i = y1; i < y1+7; i++) {
                    for (int j = x1; j < x1+12; j++) {
                        if(i==y1||i==y1+6) {
                            if (j >= x1 + 4 && j <= x1 + 6) {
                                input[i][j] = (int) (int) (7 * (pc1 / 100));
                            }
                        }
                        if(i==y1+1||i==y1+5) {
                            if (j >= x1 + 2 && j <= x1 + 9) {
                                input[i][j] = (int) (7 * (pc1 / 100));
                            }
                        }
                        if(i==y1+2||i==y1+4) {
                            if (j >= x1+1  && j <= x1 + 10) {
                                input[i][j] = (int) (7 * (pc1 / 100));
                            }
                        }
                        if (i == y1+3) {
                            input[i][j]= (int) (7*(pc1/100));
                        }
                    }
                }
                for (int i = y2; i < y2+7; i++) {
                    for (int j = x2; j < x2+12; j++) {
                        if(i==y2||i==y2+6) {
                            if (j >= x2 + 4 && j <= x2 + 6) {
                                input[i][j] = (int) (int) (7 * (pc2 / 100));
                            }
                        }
                        if(i==y2+1||i==y2+5) {
                            if (j >= x2 + 2 && j <= x2 + 9) {
                                input[i][j] = (int) (7 * (pc2 / 100));
                            }
                        }
                        if(i==y2+2||i==y2+4) {
                            if (j >= x2+1  && j <= x2 + 10) {
                                input[i][j] = (int) (7 * (pc2 / 100));
                            }
                        }
                        if (i == y2+3) {
                            input[i][j]= (int) (7*(pc2/100));
                        }
                    }
                }

                for (int i = 0; i < 257; i++) {
                    for (int j = 0; j < 257; j++) {
                        write.write(Integer.toString(input[i][j]));
                    }
                    write.write("\n");
                }
                write.close();
            }
            Model.readInput("Input.txt");


            // Asks the administrator for their preferred game length
            Scanner scanner = new Scanner(System.in);
            int gameLength = 0; // Milliseconds4
            while (gameLength < 300000 || gameLength > 600000) {
                System.out.print("Please enter the amount of time you want the game to last in " +
                        "minutes (must be between 5 and 10): ");
                if (scanner.hasNextInt()) gameLength = 60000 * scanner.nextInt();
            }


            // Begins the game and starts keeping track of time elapsed
            System.out.println("Server running");
            long startTime = System.currentTimeMillis(); // Milliseconds
            int elapsedTime = (int) (System.currentTimeMillis() - startTime); // Milliseconds
            int resourceGenerationTime = 50; // Milliseconds
            // Runs the game until the program is terminated
            while (true) {
                // -13 is the id for the game timer, the View will look up this information and decide which screen to display
                Model.players.put(-13, new Pair<>(gameLength, elapsedTime));

                Model.updateResources();
                TimeUnit.MILLISECONDS.sleep(resourceGenerationTime);
                elapsedTime = (int) (System.currentTimeMillis() - startTime);
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
