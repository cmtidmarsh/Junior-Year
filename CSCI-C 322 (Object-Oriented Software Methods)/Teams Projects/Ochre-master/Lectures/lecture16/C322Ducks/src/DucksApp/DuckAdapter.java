package DucksApp;
import java.util.Random;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class DuckAdapter extends UnicastRemoteObject implements Turkey {
	Duck duck;
	Random rand;
 
	public DuckAdapter() throws java.rmi.RemoteException {

		rand = new Random();
	}
    
	public void gobble() throws RemoteException {
		duck.quack();
	}
  
	public void fly() {
		if (rand.nextInt(5)  == 0) {
		     duck.fly();
		}
	}

	public static void main(String[] args) {
		// We need to set a security manager since this is a server.
		// This will allow us to customize access priviledges to
		// remote clients.
		System.setSecurityManager(new SecurityManager());

		try {
			// Create a WeatherServer object and announce its service to the
			// registry.

			DuckAdapter weatherServer = new DuckAdapter();
			Naming.rebind("/WeatherServer", weatherServer);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
