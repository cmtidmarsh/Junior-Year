package ducks;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class DuckServer extends UnicastRemoteObject implements DuckInt {
    protected DuckServer() throws RemoteException {
        super();
    }

    protected DuckServer(int port) throws RemoteException {
        super(port);
    }

    protected DuckServer(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public String getDuck() throws RemoteException {
        String response = "QUACK";
        System.out.println("QUACK");
        return response;
    }

    public static void main(String[] args) {
        try{
            DuckServer server = new DuckServer();
            Naming.rebind("/Duck",server);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
