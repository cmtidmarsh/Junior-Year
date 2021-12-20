import java.rmi.*;

public class RMItest {
 public static void main(String[] args) {
  
  //seems like I need to instantiate some stuff before this will work.
  try {
   System.out.println("Hello world");
   Remote robj = Naming.lookup("localhost/TestServer");
   //I'm not familiar with Remote, seems like it creates a local instance
   //of testServer, for us to interact with.
   TestIntf TestServer = (TestIntf)robj;
   //here is our interface, not familiar with (CLASS_NAME)remote_object
   //syntax. 
   while(0!=1) {
    System.out.println("Hello world.");
    Thread.sleep(500);
   }

  } catch(Exception e) {
   System.out.println("Oh boy.");
   //hopefully we don't ever see this one.
  }
 }
}
