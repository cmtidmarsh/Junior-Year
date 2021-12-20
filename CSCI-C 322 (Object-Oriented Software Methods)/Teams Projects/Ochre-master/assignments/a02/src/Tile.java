import java.awt.*;

public class Tile {
    private Color color;
    private int positionX;
    private int positionY;

    public Tile(int x, int y){
        this.positionX = x;
        this.positionY = y;
        this.color = Color.GREEN;
    }

    public void setColor(Color newColor){
        this.color = newColor;
    }

    public Color getColor() {
        return color;
    }

    public void setPosition(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }

    public Point getPosition() {
        return new Point(this.positionX, this.positionX);
    }
    
    public int getResourceValue(){return this.getResourceValue();}

}
