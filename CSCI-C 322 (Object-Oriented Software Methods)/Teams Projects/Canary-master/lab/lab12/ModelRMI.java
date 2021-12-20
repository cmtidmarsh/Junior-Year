import java.rmi.RemoteException;

public interface ModelRMI {

    public interface ModelInterface extends java.rmi.Remote{

        public void updateState() throws RemoteException;

        public void addFood() throws RemoteException;



    }
}
