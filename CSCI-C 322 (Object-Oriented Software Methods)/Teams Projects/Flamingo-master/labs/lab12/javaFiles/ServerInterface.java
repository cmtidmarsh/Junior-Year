import java.rmi.Remote;

public interface ServerInterface extends Remote {

    public GameModel(GameController controller);
    public void disconnectController(GameController controller);
}
