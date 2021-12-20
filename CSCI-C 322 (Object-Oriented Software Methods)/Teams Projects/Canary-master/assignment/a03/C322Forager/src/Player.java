import java.util.Random;

public class Player {
    private int id;
    private int positionX;
    private int positionY;
    private int collectedResources;
    private Random r;

    public Player(int x, int y, int resources) {
        this.r = new Random();
        id = r.nextInt();

        positionX = x;
        positionY = y;
        collectedResources = resources;
    }

    public int getID() { return id; }

    public void setID(int newID){ this.id = newID; }

    public Pair<Integer, Integer> getPosition() {
        return new Pair<>(positionX, positionY);
    }

    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public int getResources()
    {
        return collectedResources;
    }

    public void setResources(int resources) {
        this.collectedResources += resources;
    }
}