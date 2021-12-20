import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public interface ModelIntf extends java.rmi.Remote {
    public ArrayList<ArrayList<Cell>> getCurrentGrid() throws java.rmi.RemoteException;
    public void playerMovement() throws java.rmi.RemoteException;
}