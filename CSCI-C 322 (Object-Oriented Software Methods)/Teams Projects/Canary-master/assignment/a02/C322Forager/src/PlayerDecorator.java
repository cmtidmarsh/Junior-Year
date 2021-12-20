import java.awt.*;

public class PlayerDecorator extends TileDecorator{
    public PlayerDecorator(Tile decoratedTile) {
        super(decoratedTile);
    }

    public void draw(Graphics g)
    {
        decoratedTile.draw(g);
        g.setColor(Color.BLACK);
        g.fillOval(getX() * 10, getY() * 10, 9, 9);
    }

    @Override
    public int getX() {
        return decoratedTile.getX();
    }

    @Override
    public int getY() {
        return decoratedTile.getY();
    }
}
