import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class GameOfLifeModel extends UnicastRemoteObject implements GOLModelInterface{

    List<GameOfLifeController> LoO = new ArrayList<GameOfLifeController>();


    public GameOfLifeModel() throws RemoteException {
        super();
    }

    @Override
    public boolean[][] initial()throws RemoteException{
        Random rd = new Random();

        boolean[][] grid = new boolean[257][257];

        for (int i=0; i<256; i++) {
            for (int j=0; j<256; j++) {
                grid[i][j] = rd.nextBoolean();
            }
        }
        return grid;
    }


    @Override
    public boolean[][] incrementGeneration(boolean[][] grid)throws RemoteException{

//      game of life rules:
//        1. Any live cell with two or three live neighbours survives.
//        2. Any dead cell with three live neighbours becomes a live cell.
//        3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.
        boolean[][] temp = new boolean[grid.length][grid.length];
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                temp[i][j] = grid[i][j];
            }
        }

        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid.length-1; j++) {

                // surrounding count
                int surroundingCount = 0;

                // check all squares
                if(temp[i-1][j-1]){ surroundingCount++;}
                if(temp[i-1][j+1]){ surroundingCount++;}
                if(temp[i+1][j-1]){ surroundingCount++;}
                if(temp[i+1][j+1]){ surroundingCount++;}
                if(temp[i][j+1]){ surroundingCount++;}
                if (temp[i][j-1]){ surroundingCount++;}
                if (temp[i-1][j]){ surroundingCount++;}
                if (temp[i+1][j]){ surroundingCount++;}

                // if cell is alive
                if (temp[i][j]) {
                    if(surroundingCount < 2){
                        grid[i][j] = false;
                    }
                    //any live cell that live cell that doesn't have 2 or 3 neighbors dies
                    if ((surroundingCount == 3) || (surroundingCount == 2)) {
                        grid[i][j] = true;
                    }
                    //Any live cell with more than three live neighbours dies, as if by overpopulation.
                    if(surroundingCount > 3){
                        grid[i][j] = false;
                    }
                    // when cell is dead
                } else {
                    // Any dead cell with three live neighbours becomes a live cell.
                    if (surroundingCount == 3) {
                        grid[i][j] = true;
                    }
                }
            }
        }
        //setChanged();
        notifyObservers();
        return grid;
    }

    @Override
    public void ifChange(boolean[][] grid) throws RemoteException {
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for(GameOfLifeController c: LoO) {
            c.update(new Observable(), c);
        }
    }

    @Override
    public void addObserver(GameOfLifeController o) {
            LoO.add(o);
    }
    public static void main(String[] args) throws RemoteException{

        System.setSecurityManager(new SecurityManager());

        try{
            GameOfLifeModel m = new GameOfLifeModel();
            Naming.rebind("/GameOfLife",m);
            System.out.println("GameOfLife is ready to go");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}