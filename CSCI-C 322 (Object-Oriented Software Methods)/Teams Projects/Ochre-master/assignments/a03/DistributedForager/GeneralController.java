import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public abstract class GeneralController implements Observer, Serializable {
    ModelIntf model;
    View view;
    int playerID;
    int score;
    boolean gameOn;

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
        if (grid[0][0] == 1) {
            this.view.turnOff();
        } else if (grid[0][0] == 2) {
            this.gameOn = true;
            this.view.turnOn();
        }
        this.view.updateView(grid, players);
    }

    public void gatherResources() throws RemoteException {
        this.score += this.model.gatherResources(this.playerID);
        this.view.score = this.score;
    }

    public abstract void update(Observable o, Object arg);
}
