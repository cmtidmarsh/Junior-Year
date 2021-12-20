
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer extends UnicastRemoteObject implements HelloClient{
    //server define the action
    public HelloServer() throws java.rmi.RemoteException {
        super();
    }

    public String printMessage() throws RemoteException {
        return "Hello World!";
    }

    public static void main(String[] args){
        System.setSecurityManager(new SecurityManager());
    }

    try {
        HelloServer helloServer = new HelloServer();
        Naming.rebind("/HelloServer", helloServer);
    }
    catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

