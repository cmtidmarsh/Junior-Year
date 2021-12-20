import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

/**
 * An interface for the Forager game we are implementing in C322. Extends the java.rmi.Remote interface.
 * Provides a basic model interface that all model's will adapt. It should be interchangable with any client and still work.
 * For any modification requests before final interface, contact a member of Team 05.
 */
public interface ForagerInterface extends Remote {
    /**
     * Retrieves all of the player positions who are in the server, except for your own position as this can be client side. This can be optional but if there is a lot of lag, might cause stutter.
     * @param except The player who you want to filter out of the list. (Your client).
     * @return A hashmap of player ID's with a Pair of (X, Y) coordinates.
     * @throws RemoteException A remoteException for any undefined behavior, or connection loss.
     */
    HashMap<Integer, Pair<Integer, Integer>> getPlayerPositions(int except) throws RemoteException;

    /**
     * Sends the player's new position to the server.
     * @param playerID The player to send the position from.
     * @param positionX X coordinate of the player.
     * @param positionY Y coordinate of the player.
     * @throws RemoteException A remoteException for any undefined behavior, or connection loss.
     */
    void sendPlayerPosition(int playerID, int positionX, int positionY) throws RemoteException;

    /**
     * Returns the number of resources picked up for the playerID given as a parameter. For example, if player 1 is standing ontop of a resource that has 0 items, it returns 0. Also removes from the model.
     * @param forPlayer The playerID who picked up the resource.
     * @return The number of resources picked up by the player at that tile.
     * @throws RemoteException A remoteException for any undefined behavior, or connection loss.
     */
    int gatherResource(int forPlayer) throws RemoteException;

    /**
     * The main logic for updating resources, based off of a timer usually. Imagine GoL logic.
     * @throws RemoteException A remoteException for any undefined behavior, or connection loss.
     */
    void updateResources() throws RemoteException;

    /**
     * The board of resources, represented as a 2-d array of ints.
     * @return The resource board as a 2-d array of ints.
     * @throws RemoteException A remoteException for any undefined behavior, or connection loss.
     */
    int[][] getResources() throws RemoteException;

    void setResources(int[][] resources) throws RemoteException;

}
