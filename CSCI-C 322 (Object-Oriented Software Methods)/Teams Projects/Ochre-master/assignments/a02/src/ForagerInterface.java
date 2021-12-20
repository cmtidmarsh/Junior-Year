import java.awt.*;
import java.util.HashMap;

public interface ForagerInterface extends java.rmi.Remote {
    public HashMap<Integer, Point> getPlayerPositions(int id) throws java.rmi.RemoteException;
    public void sendPlayerPositions(int playerID, int positionX, int positionY) throws java.rmi.RemoteException;
    public int gatherResource(int forPlayer) throws java.rmi.RemoteException;;
    public void updateResources() throws java.rmi.RemoteException;
    public int[][] getResources() throws java.rmi.RemoteException;
}
