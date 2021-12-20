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
            players.add(new Player(playerID, positionX, positionY));
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
            if (p.getID() == forPlayer) player = p;
        }

        if (player != null)
        {
            Pair<Integer, Integer>  position = player.getPosition();
            int x = (int) position.getFirst();
            int y = (int) position.getSecond();
            System.out.println("gatherResource");
            System.out.println(board[x][y]);
            return board[x][y];
        }

        return 0;
    }

    @Override
    public void updateResources() throws RemoteException {
        double g = .01;
        int timer = 10;

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

    public static void main(String[] args) throws RemoteException {
        int[][] board = new int[50][50];
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                int rand = (int)Math.floor(Math.random()  * 3);
                System.out.print(rand + " ");
                board[i][j] = rand;
            }
            System.out.println();
        }

        ForagerModel m = new ForagerModel(board);
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
                t.sleep(10000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}