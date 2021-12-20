import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

public class View extends Observable implements Serializable {
    public Panel panel;
    public JFrame frame;
    public int[][] grid;
    public HashMap<Integer, Pair<Integer, Integer>> players;
    public int playerID;
    public int score;
    boolean gameOn;

    public View() {
        gameOn = false;
        grid = new int[258][258];
        players = new HashMap<Integer, Pair<Integer, Integer>>();
        frame = new JFrame();
        frame.setSize(2560, 2560);
        frame.setTitle("Conway's Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        this.panel = new Panel();
        this.panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //System.out.println(e.getKeyChar());
                setChanged();
                notifyObservers(e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.panel.setFocusable(true);
        this.panel.requestFocusInWindow();
        frame.add(this.panel);
        frame.setVisible(true);
    }

    public void updateView(int[][] grid, HashMap<Integer, Pair<Integer, Integer>> players) {
        this.grid = grid;
        this.players = players;
        this.frame.repaint();
    }

    public void turnOn() { this.gameOn = true; }

    public void turnOff() { this.gameOn = false; }

    private class Panel extends JPanel {
        JLabel jLabel;
        public Panel() {
            super();
            jLabel = new JLabel("Score: " + String.valueOf(score) + " GameOn: " + String.valueOf(gameOn));
            this.add(jLabel);
        }

        @Override
        public void paintComponent(Graphics g) {
            // call the super class methods, otherwise the background will not be colored
            super.paintComponent(g);
            this.jLabel.setText("Score: " + String.valueOf(score) + " GameOn: " + String.valueOf(gameOn));
            for (int i = 1; i < 257; i++) {
                for (int j = 1; j < 257; j++) {
                    if(grid[i][j]==0) {
                        g.setColor(Color.CYAN);
                        g.fillOval(i*10-10,j*10+10,10,10);
                    } else if (grid[i][j]==1) {
                        g.setColor(Color.blue);
                        g.fillOval(i*10-10,j*10+10,10,10);
                    } else if (grid[i][j]==2) {
                        g.setColor(Color.gray);
                        g.fillOval(i*10-10,j*10+10,10,10);
                    } else if (grid[i][j]==3) {
                        g.setColor(Color.green);
                        g.fillOval(i*10-10,j*10+10,10,10);
                    } else if (grid[i][j]==4) {
                        g.setColor(Color.darkGray);
                        g.fillOval(i*10-10,j*10+10,10,10);
                    } else if (grid[i][j]==5) {
                        g.setColor(Color.magenta);
                        g.fillOval(i*10-10,j*10+10,10,10);
                    } else if (grid[i][j]==6) {
                        g.setColor(Color.orange);
                        g.fillOval(i*10-10,j*10+10,10,10);
                    } else  {
                        g.setColor(Color.BLACK);
                        g.fillOval(i*10-10,j*10+10,10,10);
                    }
                    g.setColor(Color.BLACK);
                    g.drawOval(i*10-10,j*10+10,10,10);
                }
            }
            for(int i = 0; i < players.size(); i++) {
                if(i!=playerID) {
                    g.setColor(Color.black);
                    g.fillRect(players.get(i).getX(),players.get(i).getY(),12,12);
                }
            }
            g.setColor(Color.red);
            g.fillRect(players.get(playerID).getX(),players.get(playerID).getY(),10,10);
        }
    }
}
