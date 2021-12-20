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

    public View() {
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

    private class Panel extends JPanel {
        public Panel() { super(); }

        @Override
        public void paintComponent(Graphics g) {
            // call the super class methods, otherwise the background will not be colored
            super.paintComponent(g);
            for (int i = 1; i < 257; i++) {
                for (int j = 1; j < 257; j++) {
                    if(grid[i][j]==0) {
                        g.setColor(Color.CYAN);
                        g.fillOval(i*10-10,j*10-10,10,10);
                    } else if (grid[i][j]==1) {
                        g.setColor(Color.blue);
                        g.fillOval(i*10-10,j*10-10,10,10);
                    } else if (grid[i][j]==2) {
                        g.setColor(Color.gray);
                        g.fillOval(i*10-10,j*10-10,10,10);
                    } else if (grid[i][j]==3) {
                        g.setColor(Color.green);
                        g.fillOval(i*10-10,j*10-10,10,10);
                    } else if (grid[i][j]==4) {
                        g.setColor(Color.darkGray);
                        g.fillOval(i*10-10,j*10-10,10,10);
                    } else if (grid[i][j]==5) {
                        g.setColor(Color.magenta);
                        g.fillOval(i*10-10,j*10-10,10,10);
                    } else if (grid[i][j]==6) {
                        g.setColor(Color.orange);
                        g.fillOval(i*10-10,j*10-10,10,10);
                    } else  {
                        g.setColor(Color.BLACK);
                        g.fillOval(i*10-10,j*10-10,10,10);
                    }
                    g.setColor(Color.BLACK);
                    g.drawOval(i*10-10,j*10-10,10,10);
                }
            }
            for(int i = 0; i < players.size(); i++) {
                if(i!=playerID) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.red);
                }
                g.fillRect(players.get(i).getX(),players.get(i).getY(),10,10);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        View x = new View();
        int[][] y = new int[258][258];
        HashMap<Integer, Pair<Integer, Integer>> z = new HashMap<Integer, Pair<Integer, Integer>>();
        z.put(0, new Pair<Integer, Integer>(20, 20));
        y[1][1] = 1;
        y[1][2] = 2;
        y[1][3] = 3;
        y[1][4] = 4;
        y[1][5] = 5;
        y[1][6] = 6;
        y[1][7] = 7;
        TimeUnit.SECONDS.sleep(5);
        x.updateView(y,z);
        TimeUnit.SECONDS.sleep(5);
        z.replace(0, new Pair<Integer, Integer>(30,30));
        y[1][1] = 0;
        x.updateView(y,z);
    }
}
