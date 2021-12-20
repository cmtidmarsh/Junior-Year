import java.rmi.RemoteException;

public interface GOLModelInterface extends java.rmi.Remote{

    boolean[][] initial() throws RemoteException;
    boolean[][] incrementGeneration(boolean[][] grid) throws RemoteException;
    void ifChange(boolean[][] grid) throws RemoteException;
    void notifyObservers()throws RemoteException;
    void addObserver(GameOfLifeController o)throws RemoteException;

}
