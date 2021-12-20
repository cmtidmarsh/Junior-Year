import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public abstract class Cell extends UnicastRemoteObject implements CellModelInt{
    public int lifeState;

    protected Cell() throws RemoteException {
    }

    public abstract int getLiveNeighbors() throws RemoteException;
    public abstract void update() throws RemoteException;

}
