import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;



public class GameOfLifeController implements Observer, Serializable {

    //GameOfLifeModel model;
    GOLModelInterface model ;
    GameOfLifeView view;
    boolean[][] grid;

    public GameOfLifeController(GameOfLifeView view) throws RemoteException{
            super();
        try{

            Remote r = Naming.lookup("//localhost/GameOfLife");
            this.model = (GOLModelInterface) r;
            this.view = view;
            grid = model.initial();
            model.addObserver(this);
            run();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("updaing");
        System.out.println(grid.length);
        try {
            run();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void run() throws RemoteException {
        System.out.println("1");
        view.display(this.grid);
        System.out.println("2");
        grid = model.incrementGeneration(grid);
//        System.out.println(grid.length);
        System.out.println("3");
        //model.notifyObservers();

    }

    public static void main(String[] args) throws RemoteException {
        GameOfLifeController c = new GameOfLifeController(new GameOfLifeView());
    }
}