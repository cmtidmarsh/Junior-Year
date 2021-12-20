
import java.awt.*;
import java.rmi.Remote;

public interface RemoteModelInterface extends Remote {
    public int countPlayerResource();
    public void removeResource();
    public void setInitialPosition();
    public void clearBoard();
    public Point move();
    public void setBoard();
}

