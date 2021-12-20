import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CellModelInt extends Remote {
    public int getLiveNeighbors() throws RemoteException;
    public void update() throws RemoteException;
}
