import java.awt.*;

public class TileOne implements Tile {
    int positionX;
    int positionY;

    TileOne(int x, int y) {
        positionX = x;
        positionY = y;
    }

    @Override
    public int getX() {
        return positionX;
    }

    @Override
    public int getY() {
        return positionY;
    }

    @Override
    public void draw(Graphics g) {
        int rectSize = 10;
        g.setColor(Color.RED);
        g.fillRect(positionX * rectSize, positionY * rectSize, rectSize, rectSize);
    }
}
