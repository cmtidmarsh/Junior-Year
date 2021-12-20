

import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Random;

public class GameOfLifeModel extends Observable {

    boolean[][] grid;
    int gridWidthHeight;
    Random rd;

    public GameOfLifeModel() {
        this.gridWidthHeight = 256;
        grid = new boolean[this.gridWidthHeight+1][this.gridWidthHeight+1];
        this.rd = new Random();
        initial();
    }

    private void initial(){
        for (int i=0; i<gridWidthHeight; i++) {
            for (int j=0; j<gridWidthHeight; j++) {
                grid[i][j] = rd.nextBoolean();
            }
        }
    }

    public void incrementGeneration() {

//      game of life rules:
//        1. Any live cell with two or three live neighbours survives.
//        2. Any dead cell with three live neighbours becomes a live cell.
//        3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.
        boolean[][] temp = new boolean[this.gridWidthHeight+1][this.gridWidthHeight+1];
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                temp[i][j] = grid[i][j];
            }
        }

        for (int i = 1; i < gridWidthHeight; i++) {
            for (int j = 1; j < gridWidthHeight; j++) {

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
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < grid.length; i++){
            for(int j = 0 ; j < grid[1].length; j++){
                if(j == grid[1].length-1){
                    s += grid[i][j] + "\n";
                }else{
                    s += grid[i][j] + " ";
                }
            }
        }
        return s;
    }
}