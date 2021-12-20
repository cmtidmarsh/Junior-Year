import java.rmi.*;
//confused why we need this next line if we just imported rmi.* \o/
import java.rmi.server.UnicastRemoteObject;
//suppose it is showing exactly;
public class TestServer extends UnicastRemoteObject implements TestIntf {


 public TestServer() throws java.rmi.RemoteException { 
  super(); //super duper
 }
 public String test() {
  return "testing 1 2 3";
 }

 public static void main(String[] args) {
  //aparently we need this because it's a server, but considering this is localhost
  //I'm guessing it's not THAT important.
  
  System.setSecurityManager(new SecurityManager());

  try {
   //so we instantiate a server in the interface
   TestServer TestServer = new TestServer();
   Naming.rebind("/TestServer", TestServer);

  } catch (Exception e) {
   System.out.println("coming at you life from TestServer fm - this is an error!");
  }
 }
}

