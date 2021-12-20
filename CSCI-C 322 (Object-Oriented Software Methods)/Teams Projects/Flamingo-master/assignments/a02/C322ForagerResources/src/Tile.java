import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Tile extends JComponent {
    Color color; // I do think we should make this change, originally of type String
    int positionX, positionY, state = 0;
    public static int CELLSIZE = 15;

    private Color BLACK = new Color(0,0,0);
    ArrayList<Color> stateColors = new ArrayList<Color>() {{
        add(Color.WHITE);
        add(new Color(255,0,0));
        add(new Color(255,140, 0));
        add(new Color(255,255,0));
        add(new Color(0,255,255));
        add(new Color(255,0,255));
        add(new Color(0,0,255));
        add(new Color(0,128,0));
        add(new Color(0,255,0));
    }};


    public Tile(int x, int y ) {
        this.positionX = x;
        this.positionY = y;
        
    }

    public Tile(int x, int y, int state ) {
        this.positionX = x;
        this.positionY = y;
        this.state = state;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    private Color getCellColor() {
        int i = this.state;
        if (i <= 8) {
            return stateColors.get(i);
        }
        return Color.black;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getCellColor());
        g2.fillRect(this.positionX * CELLSIZE, this.positionY * CELLSIZE, CELLSIZE, CELLSIZE);

        g2.setColor(BLACK);
        g2.drawRect(this.positionX * CELLSIZE, this.positionY * CELLSIZE, CELLSIZE, CELLSIZE);
    };

}
