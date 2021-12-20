import java.awt.*;

public class PlayerDecorator extends TileDecorator{
    private Color color;
    public PlayerDecorator(Tile decoratedTile, Color color) {
        super(decoratedTile);
        this.color = color;
    }

    public void draw(Graphics g)
    {
        decoratedTile.draw(g);
        g.setColor(this.color);
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
