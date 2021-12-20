package DucksApp;
import java.rmi.*;

public class TurkeyTestDrive {
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();


		try {
			// Obtain a reference to an object that lives remotely on a server.
			// The object is published under the service name WeatherServer and
			// it is known to implement interface WeatherIntf.  We cast to this
			// interface in order to access the object's methods.
			Remote robj = Naming.lookup("//localhost/WeatherServer");
			Duck weatherServer = (Duck) robj;

			// Access the services provided by the remote object.
			while (true) {
				weatherServer.quack();
				Thread.sleep(500);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
