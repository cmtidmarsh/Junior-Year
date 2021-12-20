import java.rmi.RemoteException;
import java.util.HashMap;

public interface ModelIntf extends java.rmi.Remote {
    public HashMap<Integer, Pair<Integer, Integer>> getPlayerPositions(int except) throws RemoteException;
    public void sendPlayerPosition(int playerID, int positionX, int positionY) throws RemoteException;
    public int gatherResources(int forPlayer) throws RemoteException;
    public void updateResources() throws RemoteException;
    public int[][] getResources() throws RemoteException;
}
