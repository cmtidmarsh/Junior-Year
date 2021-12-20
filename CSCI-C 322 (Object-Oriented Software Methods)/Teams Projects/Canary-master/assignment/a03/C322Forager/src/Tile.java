import java.awt.*;

public interface Tile {
   public void draw(Graphics g);

   public int getX();

   public int getY();
}

//    Color color;
//    int positionX;
//    int positionY;

//    Tile(Color color, int positionX, int positionY) {
//        this.color = color;
//        this.positionX = positionX;
//        this.positionY = positionY;
//    }
//
//    void setColor(Color color) {
//        this.color = color;
//    }
//
//    public void setPositions(int x, int y) {
//        this.positionX = x;
//        this.positionY = y;
//    }
//
//    public Color getColor() { return color; }
//
//    public int getPositionX() { return positionX; }
//
//    public int getPositionY() { return positionY; }
//
//    public void draw(Graphics g) {
//        int rectSize = 10;
//        g.setColor(color);
//        g.fillRect(getPositionX() * rectSize, getPositionY() * rectSize, rectSize, rectSize);
//    }
