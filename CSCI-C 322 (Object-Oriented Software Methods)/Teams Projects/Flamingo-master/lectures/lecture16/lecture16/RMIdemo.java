import java.rmi.*;

 public class RMIdemo {
    public static void main(String[] args) {
        try {
            // Obtain a reference to an object that lives remotely on a server.
            // The object is published under the service name WeatherServer and
            // it is known to implement interface WeatherIntf.  We cast to this
            // interface in order to access the object's methods.
            Remote robj = Naming.lookup("//localhost/HelloServer");
            HelloIntf HelloServer = (HelloIntf)robj;

            // Access the services provided by the remote object.
            while (0 != 1) {
               
                System.out.println("Hello world.");
                Thread.sleep(500);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
