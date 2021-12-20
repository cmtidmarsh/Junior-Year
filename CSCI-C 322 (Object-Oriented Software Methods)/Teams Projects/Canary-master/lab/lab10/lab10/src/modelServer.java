

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class modelServer extends UnicastRemoteObject implements RMI{

    public modelServer() throws RemoteException {
        super();
    }

    @Override
    public boolean[][] getGrid() throws RemoteException {
        return m.grid;
    }


    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());

        try {
            modelServer m = new modelServer();
            Naming.rebind("/modelServer", m);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
