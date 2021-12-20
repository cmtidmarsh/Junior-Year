import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observable;
import java.util.Observer;

public class Controller {
    public View view;
    public ForagerInterface model;
    long startTime = 0;

    public Controller(ForagerInterface model, View view) {
        this.model = model;
        this.view = view;
        this.startTime = System.currentTimeMillis();
    }

    public void run() throws RemoteException {
        while (true) {
            long timePassed = (System.currentTimeMillis() - this.startTime) / 1000;
            // after 10 minutes end game
            if (timePassed == 10 * 60) {
                System.out.println("Game Over! 10 minutes has passed");
                break;
            }
            model.sendPlayerPosition(view.player.getID(), view.player.positionX, view.player.positionY);
            model.gatherResource(view.player.getID());
            view.player.collectedResources += model.gatherResource(view.player.getID());
            view.updateView(model.getResources(), model.getPlayers(), timePassed);
            model.updateResources();
        }
    }


    //THIS IS THE USER TANNER
    public static void main(String[] args) {

        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry(null);

            // Looking up the registry for the remote object
            ForagerInterface stub = (ForagerInterface) registry.lookup("asdfasdf");

            // Calling the remote method using the obtained object
            stub.printMsg();
            View testView = new View();
            Controller testController = new Controller(stub, testView);

            testController.run();
            // System.out.println("Remote method invoked");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}