import java.util.ArrayList;

public interface ModelInterface extends java.rmi.Remote {
    void initializeGrid() throws java.rmi.RemoteException;
    void updateCells() throws java.rmi.RemoteException;
    int[][] getCurrentArray() throws java.rmi.RemoteException;
    ArrayList<ArrayList<Integer>> getFutureArray() throws java.rmi.RemoteException;

    void addObserver(GameOfLifeController controller);
    //void update() throws java.rmi.RemoteException;

}
