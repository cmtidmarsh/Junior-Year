import java.rmi.RemoteException;

public class ControllerFactory {
    public GeneralController createController(boolean admin, ModelIntf model, View view) throws RemoteException {
        if (admin) { return new AdminController(model,view); }
        else { return new Controller(model,view); }
    }
}
