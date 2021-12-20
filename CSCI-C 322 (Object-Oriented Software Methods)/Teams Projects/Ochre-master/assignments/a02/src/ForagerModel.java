import java.awt.*;
import java.sql.Array;
import java.util.*;

public class ForagerModel {
    private int[][] resources;
    private Player[] players;
    private HashMap<Integer, Point> playersPositions;
    public Timer timer;
    private ArrayList<Point> movements;


    private boolean updateBool = false;

    public ForagerModel() {
        this.resources = new int[20][20];
        this.playersPositions = new HashMap<>();
    }

    public void registerPlayer(Player player){
        // adds a new player to the hash map
        playersPositions.put(player.getId(), player.getPosition());
        System.out.println(playersPositions);
    }

    //implement this
    public ArrayList<Point> getPlayerPositions(int id){
        //the set of all player ids in the hash map "playersPositions"
        Set playerIDs = playersPositions.keySet();

        //convert the set to an iterator
        Iterator<Integer> ids = playerIDs.iterator();
        ArrayList<Point> otherPlayerPosisions = new ArrayList<Point>();

        //iterate over the id's and make sure the value is not the player's id
        while(ids.hasNext()){
            Integer currentID = ids.next();
            if(currentID != id){
                otherPlayerPosisions.add(playersPositions.get(currentID));
            }
        }
        return otherPlayerPosisions;
    }

    //implement this
    public void sendPlayerPositions(int playerID, int positionX, int positionY){
        playersPositions.put(playerID, new Point(positionX, positionY));
    }

    //implement this
    public int gatherResource(int forPlayer){
        // Based on where the player is -> Tile: We should access the resources available at that location
        for (int i=0; i<players.length; i++) {
            if (forPlayer == i) {
                Player player = players[i];
                // player.updateResources();
            }
        }
        return 1;
    }

    //implement this
    public void updateResources(){

    }

    //implement this
    public int[][] getResources(){
        return new int[0][0];
    }


}
