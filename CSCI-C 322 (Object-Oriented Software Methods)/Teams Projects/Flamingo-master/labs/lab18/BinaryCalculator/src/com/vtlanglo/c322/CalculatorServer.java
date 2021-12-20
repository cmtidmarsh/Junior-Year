import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

 public class CalculatorServer extends UnicastRemoteObject implements CalculatorIntf {
    public CalculatorServer() throws java.rmi.RemoteException {
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
        //ok great.

        try {
            // Create a WeatherServer object and announce its service to the
            // registry. nah, we are creating a calcview.
           //CalcView view = new CalcView();
           CalculatorServer CalculatorServer = new CalculatorServer();
           Naming.rebind("/CalculatorServer", CalculatorServer);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
