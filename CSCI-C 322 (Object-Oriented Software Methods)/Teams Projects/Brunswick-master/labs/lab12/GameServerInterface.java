import java.util.ArrayList;

// Team 03 - Brunswick
// Tyler Burdon tcburdon
// Dylan Hertoge dherthog
// Jiaqi Huang jh106

public interface GameServerInterface extends java.rmi.Remote
{
    public Location<int, int> getResourceLocation() throws java.rmi.RemoteException;

    public ArrayList<Location<int, int>> getPlayerLocations(String op) throws java.rmi.RemoteException;

    public Location<int, int> giveCurrentLocation(Player player) throws java.rmi.RemoteException;

    public int notifyResourceConsumed(Player player, Resource resource, int time) throws java.rmi.RemoteException;

}
