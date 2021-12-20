import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

public class AdminController extends GeneralController {

    public AdminController(ModelIntf model, View view) throws RemoteException {
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
            } else if (arg.equals('b') && !gameOn) {
                this.sendPlayerPosition(this.playerID, 1, 0);
            } else if (arg.equals('1') && !gameOn) {
                this.sendPlayerPosition(this.playerID, 2, 0);
            } else if (arg.equals('2') && !gameOn) {
                this.sendPlayerPosition(this.playerID, 3, 0);
            } else if (arg.equals('3') && !gameOn) {
                this.sendPlayerPosition(this.playerID, 4, 0);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

