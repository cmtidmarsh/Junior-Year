import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public interface IntfForagerModel extends java.rmi.Remote {
   public ArrayList<Resource> getResourceLocation() throws java.rmi.RemoteException;
   public int notifyResourceConsumed(Player p, Resource id);
   }