package DucksApp;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public interface Turkey extends java.rmi.Remote{
	public void gobble () throws RemoteException;
	public void fly();
}
