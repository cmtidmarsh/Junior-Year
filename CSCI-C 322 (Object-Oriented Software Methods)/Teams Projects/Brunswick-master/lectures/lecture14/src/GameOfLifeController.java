//C322 Lecture 14 Task - Lab08
//Team03
//3-11-21
//Ben Billings (benbilli@iu.edu), Jiahui Chang (chanji@iu.edu), Chris Taddeucci (ctaddeuc@iu.edu)

import java.io.IOException;
import java.util.*; //imports observer-observable
import java.io.File;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class GameOfLifeController implements Observer{

    //GameOfLifeModel model;

    ModelInterface model;
    GameOfLifeView view;

    public GameOfLifeController(ModelInterface model, GameOfLifeView view){
        this.model = model;
        //model.initializeGrid();
        this.view = view;
        this.model.addObserver(this);
    }


    public static void main(String[] args) throws IOException {

//        GameOfLifeModel model = new GameOfLifeModel();
//        //System.out.print(model.getCurrentArray());
//
//        GameOfLifeView view = new GameOfLifeView();
//        GameOfLifeController observer = new GameOfLifeController(model, view);
//        observer.model.initializeGrid();
//

        try{

            Remote obj = Naming.lookup("//localhost/GameOfLifeModel");
            ModelInterface model = (ModelInterface)obj;
            GameOfLifeView view = new GameOfLifeView();
            GameOfLifeController observer = new GameOfLifeController(model, view);
            observer.model.initializeGrid();

            while (true){
                //get update from model
                //observer.model.updateCells();




            }

        } catch (Exception e){

        }


    }


    @Override
    public void update(Observable o, Object arg){

        int[][] arr = new int[0][];
        try {
            arr = this.model.getCurrentArray();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.view.updateGrid(arr);

//        for(int i = 0; i < 256; i++) {
//            for (int j = 0; j < 256; j++) {
//                this.view.updateGrid(i, j, arr[i][j]);
//            }
//        }
    }



}
