//C322 Lecture 14 Task - Lab08
//Team03
//3-11-21
//Ben Billings (benbilli@iu.edu), Jiahui Chang (chanji@iu.edu), Chris Taddeucci (ctaddeuc@iu.edu)

import java.util.*; //import observer-observable
import java.io.*;
import java.rmi.*;


public class GameOfLifeModel extends Observable implements ModelInterface, Serializable {
    ArrayList<Observer> observerList = new ArrayList<>();
    int[][] currentArray;
    ArrayList<ArrayList<Integer>> futureArray = new ArrayList<>();

    public GameOfLifeModel() throws IOException{ //constructor

        currentArray = new int[256][256];

        FileReader file = new FileReader("input.txt");
        Scanner in = new Scanner(file);
        String str;
        ArrayList<Integer> array = new ArrayList<>();
        int num = 0;
        while(in.hasNext()){
           str = in.next();

           for(int i = 0; i < str.length(); i++){
               num = str.charAt(i) + 0;

               if(num == 48) {
                   array.add(0);

               }else if (num == 49)    {
                   array.add(1);
               }

           }


        }


        int count = 0;
        for(int i = 0; i < 256; i++){
            for(int j = 0; j < 256; j++){

                currentArray[i][j] = array.get(count);
                count += 1;

            }
        }

        in.close();



    }


    public int[][] getCurrentArray(){
        return currentArray;
    }

    public ArrayList<ArrayList<Integer>> getFutureArray(){
        return futureArray;
    }

    public void initializeGrid() throws RemoteException{
        setChanged();
        notifyObservers();

    }

    public void updateCells() throws RemoteException{


        //setChanged();
        //notifyObservers();
    }

    @Override
    public void addObserver(GameOfLifeController controller) {
       observerList.add(controller) ;
    }

    public void findAndKillNewCells(){
        //notifyObservers();
    }

    public static void main(String[] args){

        System.setSecurityManager(new SecurityManager());

        try{
            GameOfLifeModel model = new GameOfLifeModel();
            Naming.rebind("/GameOfLifeModel", model);

        } catch (Exception e){

            System.out.println(e.getMessage());

        }
    }



}
