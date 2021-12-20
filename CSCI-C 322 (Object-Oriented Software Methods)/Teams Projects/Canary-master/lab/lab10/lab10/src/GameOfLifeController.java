

import javax.swing.text.View;
import java.awt.*;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import static java.awt.Color.*;


public class GameOfLifeController implements Observer {

    RMI model;
    GameOfLifeView view;

    public GameOfLifeController(GameOfLifeView v, RMI m) throws RemoteException{
        super();
        this.model = m;
        this.view = v;
        model.m.addObserver(this);
        run();
    }

    @Override
    public void update(Observable o, Object arg) {
        run();

    }

    private void run(){
        view.display(model.m.grid);
        System.out.println(model.m.toString());
        model.m.incrementGeneration();
    }

    public static void main(String[] args) throws RemoteException {
        try {
            Remote robj = Naming.lookup("//localhost/modelServer");
            RMI modelServer = (RMI) robj;
            GameOfLifeController c = new GameOfLifeController(new GameOfLifeView(), modelServer);
            // Access the services provided by the remote object.

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}