

public interface RMI extends java.rmi.Remote{
    GameOfLifeModel m = new GameOfLifeModel();
    boolean[][] getGrid() throws java.rmi.RemoteException;
}
