import java.rmi.Naming;
import java.rmi.RemoteException;

public class LiveCell extends Cell{

    protected LiveCell() throws RemoteException {
    }

    @Override
    public int getLiveNeighbors(){
        return 0;
    }

    @Override
    public void update() {
        super.lifeState = 1;
    }

    public static void main(String[] args) {
        // We need to set a security manager since this is a server.
        // This will allow us to customize access priviledges to
        // remote clients.
        System.setSecurityManager(new SecurityManager());

        try {
            // Create a WeatherServer object and announce its service to the
            // registry.
            LiveCell liveCell = new LiveCell();
            Naming.rebind("LiveCell", liveCell);
            System.out.println("LiveCell is ready.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
