import java.awt.*;

public abstract class TileDecorator implements Tile{
    protected Tile decoratedTile;

    public TileDecorator(Tile decoratedTile){
        this.decoratedTile = decoratedTile;
    }

    public void draw(Graphics g)
    {
        decoratedTile.draw(g);
    }
}
