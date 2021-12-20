import java.awt.*;
import java.rmi.Remote;

public interface RemoteModelInterface extends Remote {
    public boolean[][] getBoard();
    public void toggleCellManually(int row, int col);
    public boolean setIsPlaying(int isPlaying);
    public void setTickRate(int tickrate);
    public int getTickrate();
    public void notifyObserver();
    public void step();
    public int countLiveNeighbors(int row, int col);
    public Point getPlayerMovements();
    public void sendPlayerMovements();
    public int gatherResources(Player p);
    public void updateResources();
}