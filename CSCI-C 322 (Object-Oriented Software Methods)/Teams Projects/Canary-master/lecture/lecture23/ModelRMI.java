import java.rmi.RemoteException;

public interface ModelRMI {

    public interface ModelInterface extends java.rmi.Remote{

        public int[] getPlayerMovements() throws RemoteException;

        public void sendPlayerMovements() throws RemoteException;
		
		public void gatherResource(Player player) throws RemoteException;
		
		public void updateResources() throws RemoteException;
		
		public String[][] getBoard() throws RemoteException;



    }
}
