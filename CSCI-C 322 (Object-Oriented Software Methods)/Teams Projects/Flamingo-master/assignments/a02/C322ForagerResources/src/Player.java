import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends JComponent implements KeyListener {
    public static int PLAYER_SIZE = 15; // Suggest that this is the same as the tile size

    int id, positionX = 0;
    int positionY = 0;
    int collectedResources = 0;
    int key;
    private Color BLACK = new Color(0,0,0);


    public Player(int id) { this.id = id; }
    public int getID() { return this.id; }

    // public Pair<Integer, Integer> getPosition() { return new Pair<>(x, y); }

    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public void setResources(int resource) {
        this.collectedResources = resource;
    }

    public void setID(int id){
        this.id = id;
    }


    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(BLACK);

        g2.fillOval(this.positionX * PLAYER_SIZE, this.positionY * PLAYER_SIZE, PLAYER_SIZE, PLAYER_SIZE);
        // g2.drawOval(this.positionX * PLAYER_SIZE, this.positionY * PLAYER_SIZE, PLAYER_SIZE, PLAYER_SIZE);
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        int pressedKey = e.getKeyCode();
        System.out.println("keypressed");
        if (pressedKey == KeyEvent.VK_LEFT) {
//             System.out.println("LEFT");
            this.key = 0;
            if (this.positionX > 0) { this.positionX -= 1; }
        }

        if (pressedKey == KeyEvent.VK_RIGHT) {
//             System.out.println("RIGHT");
            this.key = 1;
            if (this.positionX < Model.BOARDSIZE) { this.positionX += 1; }
        }

        if (pressedKey == KeyEvent.VK_UP) {
//             System.out.println("UP");
            this.key = 2;
            if (this.positionY > 0) { this.positionY -= 1; }
        }

        if (pressedKey == KeyEvent.VK_DOWN) {
//             System.out.println("DOWN");
            this.key = 3;
            if (this.positionY < Model.BOARDSIZE) { this.positionY += 1; }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}
