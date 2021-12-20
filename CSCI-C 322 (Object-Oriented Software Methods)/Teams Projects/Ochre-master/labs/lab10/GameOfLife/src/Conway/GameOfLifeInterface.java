package Conway;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameOfLifeInterface extends Remote {
    void setBoard(int[][] board) throws RemoteException;
    int[][] getBoard() throws RemoteException;
    void simulateCycle();
}
