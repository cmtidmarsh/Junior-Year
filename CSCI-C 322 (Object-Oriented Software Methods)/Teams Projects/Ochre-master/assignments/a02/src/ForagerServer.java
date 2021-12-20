import java.awt.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class ForagerServer extends UnicastRemoteObject implements ForagerInterface {
    public Map<Controller, ForagerModel> controllerToModels;

    public ForagerServer() throws java.rmi.RemoteException {
        super();
    }

    //implement this
    public ForagerModel requestModel(Controller inputController){
        if (this.controllerToModels.get(inputController) == null){
            this.controllerToModels.put(inputController, new ForagerModel());
        }
        return this.controllerToModels.get(inputController);
    }

    @Override
    public HashMap<Integer, Point> getPlayerPositions(int id) throws RemoteException {
        return null;
    }

    @Override
    public void sendPlayerPositions(int playerID, int positionX, int positionY) throws RemoteException {

    }

    @Override
    public int gatherResource(int forPlayer) throws RemoteException {
        return 0;
    }

    public void updateResources() throws RemoteException {

    }

    public int[][] getResources() throws RemoteException {
        return new int[0][];
    }
}
