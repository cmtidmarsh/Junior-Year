import java.awt.*;

public class Player {
    private int playerId;
    private int positionX;
    private int positionY;
    private int collectedResources;

    public Player(int id, int positionX, int positionY){
        this.playerId = id;
        this.positionX = positionX;
        this.positionY = positionY;
        this.collectedResources = 0;
    }

    public int getId() {
        return playerId;
    }

    public Pair<Integer,Integer> getPosition() {
        return new Pair<Integer, Integer>(positionX, positionY);
    }

    public void setPosition(int first, int second) {
        this.positionX = first;
        this.positionY = second;
    }

    public void addResources(int collectedResources) {
        this.collectedResources += collectedResources;
    }

    public int getResources() { return collectedResources; }

    public void moveUp() { if (positionY>0) positionY -=1; }

    public void moveDown() { if (positionY<255) positionY +=1; }

    public void moveLeft() { if (positionX>0) positionX -=1; }

    public void moveRight() { if (positionX<255) positionX +=1; }

    public Color getColor() { return Color.CYAN; }
}
