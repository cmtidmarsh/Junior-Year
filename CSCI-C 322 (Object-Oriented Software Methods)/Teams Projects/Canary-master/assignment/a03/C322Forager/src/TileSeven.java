import java.awt.*;

public class TileSeven implements Tile {
    int positionX;
    int positionY;

    TileSeven(int x, int y) {
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
        g.setColor(Color.magenta);
        g.fillRect(positionX * rectSize, positionY * rectSize, rectSize, rectSize);
    }
}
