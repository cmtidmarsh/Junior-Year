import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Cell
{
    private int resourceLevel;
    private int x;
    private int y;

    Cell(int resourceLevel, int x, int y)
    {
        this.resourceLevel = resourceLevel;
        this.x = x;
        this.y = y;
    }

    public int getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(int resourceLevel) { this.resourceLevel = resourceLevel; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int update(int[][] board) {

        // Determines which/how many neighbors are alive

        int activeNeighbors = 0;
        // top left
        try {
            activeNeighbors += (board[x-1][y-1] > 0 ? 1 : 0);
        } catch (ArrayIndexOutOfBoundsException e) {}
        // top
        try {
            activeNeighbors += (board[x-1][y] > 0 ? 1 : 0);
        } catch (ArrayIndexOutOfBoundsException e) {}
        // top right
        try {
            activeNeighbors += (board[x-1][y+1] > 0 ? 1 : 0);
        } catch (ArrayIndexOutOfBoundsException e) {}
        // left
        try {
            activeNeighbors += (board[x][y-1] > 0 ? 1 : 0);
        } catch (ArrayIndexOutOfBoundsException e) {}
        // right
        try {
            activeNeighbors += (board[x][y+1] > 0 ? 1 : 0);
        } catch (ArrayIndexOutOfBoundsException e) {}
        // bottom left
        try {
            activeNeighbors += (board[x+1][y-1] > 0 ? 1 : 0);
        } catch (ArrayIndexOutOfBoundsException e) {}
        // bottom
        try {
            activeNeighbors += (board[x+1][y] > 0 ? 1 : 0);
        } catch (ArrayIndexOutOfBoundsException e) {}
        // bottom left
        try {
            activeNeighbors += (board[x+1][y+1] > 0 ? 1 : 0);
        } catch (ArrayIndexOutOfBoundsException e) {}

        Random r = new Random();
        float test = r.nextFloat();
        float N = 8; // the number of adjacent cells we're checking

        // Grow the current cell
        float possibleNewResourceLevel = 0.15f * (activeNeighbors/N);

        if(test < possibleNewResourceLevel && this.resourceLevel < 7){
            this.resourceLevel += 1;
        }

        return this.resourceLevel;
    }
}
