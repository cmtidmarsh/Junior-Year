import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DeadCell extends Cell{

    protected DeadCell() throws RemoteException {
    }

    @Override
    public int getLiveNeighbors(){
        return 0;
    }

    @Override
    public void update(){
        super.lifeState = 0;
    }

    public static void main(String[] args) {
        // We need to set a security manager since this is a server.
        // This will allow us to customize access priviledges to
        // remote clients.
        System.setSecurityManager(new SecurityManager());

        try {
            // Create a WeatherServer object and announce its service to the
            // registry.
            DeadCell deadCell = new DeadCell();
            Naming.rebind("Dead", deadCell);
            System.out.println("DeadCell is ready.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
