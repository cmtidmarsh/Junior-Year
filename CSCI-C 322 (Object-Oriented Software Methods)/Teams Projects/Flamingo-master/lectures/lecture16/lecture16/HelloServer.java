import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

 public class HelloServer extends UnicastRemoteObject implements HelloIntf {
    public HelloServer() throws java.rmi.RemoteException {
        super();
   }

    // The method that will be invoked by the client.
    //public String getWeather() throws RemoteException {
    //    return Math.random() > 0.5 ? "sunny" : "rainy";
    //}

    public static void main(String[] args) {
        // We need to set a security manager since this is a server.
        // This will allow us to customize access priviledges to
        // remote clients.
        System.setSecurityManager(new SecurityManager());

        try {
            // Create a WeatherServer object and announce its service to the
            // registry.
           HelloServer HelloServer = new HelloServer();
           Naming.rebind("/HelloServer", HelloServer);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
