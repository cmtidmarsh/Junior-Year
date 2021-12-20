import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

public class Controller implements Observer, Serializable {
    ModelIntf model;
    View view;
    int playerID;
    int score;

    public Controller(ModelIntf model, View view) throws RemoteException {
        this.model = model;
        this.view = view;
        this.view.addObserver(this);
        this.playerID = -1;
        this.getPlayerPositions(this.playerID);
        this.view.playerID = this.playerID;
        score = 0;
    }

    public HashMap<Integer, Pair<Integer, Integer>> getPlayerPositions(int except) throws RemoteException {
        HashMap<Integer, Pair<Integer, Integer>> players = model.getPlayerPositions(except);
        if (this.playerID == -1) { this.playerID = players.size()-1; }
        return players;
    }

    public int[][] getResources() throws RemoteException {
        return model.getResources();
    }

    public void sendPlayerPosition(int playerID, int positionX, int positionY) throws RemoteException {
        this.model.sendPlayerPosition(playerID,positionX,positionY);
    }

    public void updateView() throws RemoteException {
        int[][] grid = this.getResources();
        HashMap<Integer, Pair<Integer, Integer>> players = this.getPlayerPositions(this.playerID);
        this.view.updateView(grid, players);
    }

    public void update(Observable o, Object arg) {
        try {
            if(arg.equals('w')) {
                this.sendPlayerPosition(playerID, 0, -10);
            } else if (arg.equals('s')) {
                this.sendPlayerPosition(playerID, 0, 10);
            } else if (arg.equals('a')) {
                this.sendPlayerPosition(playerID, -10, 0);
            } else if (arg.equals('d')) {
                this.sendPlayerPosition(playerID, 10, 0);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Remote robj = Naming.lookup("//localhost/Model");
            ModelIntf ModelServer = (ModelIntf) robj;
            View view = new View();
            Controller game = new Controller(ModelServer, view);
            while (true) {
                game.updateView();
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
