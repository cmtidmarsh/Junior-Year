import java.rmi.RemoteException;
import java.util.Observable;

public class Controller extends GeneralController {

    public Controller(ModelIntf model, View view) throws RemoteException {
        this.model = model;
        this.view = view;
        this.view.addObserver(this);
        this.playerID = -1;
        this.getPlayerPositions(this.playerID);
        this.view.playerID = this.playerID;
        score = 0;
    }

    public void update(Observable o, Object arg) {
        try {
            if(arg.equals('w')) {
                this.sendPlayerPosition(this.playerID, 0, -10);
                this.gatherResources();
            } else if (arg.equals('s')) {
                this.sendPlayerPosition(this.playerID, 0, 10);
                this.gatherResources();
            } else if (arg.equals('a')) {
                this.sendPlayerPosition(this.playerID, -10, 0);
                this.gatherResources();
            } else if (arg.equals('d')) {
                this.sendPlayerPosition(this.playerID, 10, 0);
                this.gatherResources();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
