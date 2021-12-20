import java.awt.*;
import java.util.ArrayList;

public class Player {
    private int id;
    private int positionX;
    private int positionY;
    private Point position;
    private int collectedResources;

    private int boardHeight;
    private int boardWidth;

    private ArrayList<Point> movements;

    //added
    private String movement;

    Player(int id, int x, int y) {
        this.id = id;
        this.position = new Point(x, y);
        this.movement = " ";

        this.boardHeight = 10;
        this.boardWidth = 10;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public Point getPosition(){
        return new Point(this.positionX, this.positionY);
    }

    public void setPosition(String lastInput){

        if(lastInput.equals("a")  && positionX > 0) {
            positionX = positionX - 1;
            System.out.println("left");
        }
        else if(lastInput.equals("s")&& positionY < boardHeight - 1){
            positionY = positionY +1;
            System.out.println("up");
        }
        else if(lastInput.equals("w") && positionY > 0){
            positionY = positionY -1;
            System.out.println("down");
        }
        else if(lastInput.equals("d") && positionX < boardWidth - 1){
            positionX = positionX +1;
            System.out.println("right");
        }

        else if(lastInput.equals("e")){
            System.out.println("gathering resources");
        }
    }

    public void setResources(int resourceNumber){
        this.collectedResources = resourceNumber;
    }

    // NEW
    public void updateResources(int resources){
        this.collectedResources += resources;
    }

    public int getResources(){
        return collectedResources;
    }

    // TODO
    // NEW
    public void updateMovements() {
        movements.add(this.getPosition());
    }
    // TODO
    // NEW
    public ArrayList<Point> getMovement() {
        return movements;
    }
}
