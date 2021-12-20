import java.rmi.RemoteException;
import java.util.HashMap;

public interface ForagerIntf extends java.rmi.Remote {
    HashMap<Integer, Pair<Integer, Integer>> getPlayerPositions(int except) throws RemoteException;
    void sendPlayerPosition(int playerID, int positionX,int positionY) throws RemoteException;
    int gatherResource(int forPlayer) throws RemoteException;
    void updateResources() throws RemoteException;
    int[][] getResources() throws RemoteException;
}
