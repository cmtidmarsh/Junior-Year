import java.awt.*;

public class TileZero implements Tile {
    int positionX;
    int positionY;

    TileZero(int x, int y) {
        positionX = x;
        positionY = y;
    }

    @Override
    public void draw(Graphics g) {
        int rectSize = 10;
        g.setColor(Color.white);
        g.fillRect(positionX * rectSize, positionY * rectSize, rectSize, rectSize);
    }

    @Override
    public int getX() {
        return positionX;
    }

    @Override
    public int getY() {
        return positionY;
    }
}
