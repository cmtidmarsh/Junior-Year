import java.rmi.Remote;
import java.util.Observer;


public interface ModelInterface extends Remote {

    public void step();
    public void setObservers(Observer o);
    public void notifyObserver();
}
