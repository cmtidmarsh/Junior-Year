//C322 Lecture 14 Task - Lab08
//Team03
//3-11-21
//Ben Billings (benbilli@iu.edu), Jiahui Chang (chanji@iu.edu), Chris Taddeucci (ctaddeuc@iu.edu)

import java.util.*; //imports observer-observable

public class GameOfLifeController implements Observer{

    GameOfLifeModel model;
    GameOfLifeView   view;

    public GameOfLifeController(GameOfLifeModel model, GameOfLifeView view){
        this.model = model;
        this.view  =  view;
        this.model.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg){
        runGameOfLife();
    }

    public void runGameOfLife(){
        view.drawNewArr(model.getNew2DArray());
        model.update2DArray();
    }

    public static void main(String[] args){
        GameOfLifeModel m = new GameOfLifeModel();
        GameOfLifeView  v = new GameOfLifeView ();
        GameOfLifeController gameOfLifeController = new GameOfLifeController(m, v);
        gameOfLifeController.runGameOfLife();
    }
}