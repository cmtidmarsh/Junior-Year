//import java.rmi.Naming;
//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;
//
//public class server extends UnicastRemoteObject{
//    protected server() throws RemoteException {
//        GameOfLifeModel model = new GameOfLifeModel();
//    }
//
//    public static void main(String[] args) {
//
//        try {
//            System.out.println("GameOfLive Server Running");
//            server s = new server();
//            Naming.rebind("/GameOfLife",s);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}