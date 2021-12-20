import javax.swing.text.View;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import static java.awt.Color.*;


public class GameOfLifeController implements Observer {

    GameOfLifeModel model;
    GameOfLifeView view;

    public GameOfLifeController(GameOfLifeView v, GameOfLifeModel m){
        this.model = m;
        this.view = v;
        model.addObserver(this);
        run();
    }

    @Override
    public void update(Observable o, Object arg) {
        run();
    }

    private void run(){
        view.display(model.grid);
        model.incrementGeneration();
    }

    public static void main(String[] args) {
        GameOfLifeController c = new GameOfLifeController(new GameOfLifeView(),new GameOfLifeModel());
    }
}