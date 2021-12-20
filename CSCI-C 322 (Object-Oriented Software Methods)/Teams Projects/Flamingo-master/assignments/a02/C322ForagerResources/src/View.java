import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;

public class View extends JFrame {
    public static int WIDTH = 1024;
    public static int HEIGHT = 1024;

    Player player = new Player(10);
    private Panel panel;
    int[][] board = new int[50][50];
    HashMap<Integer, Pair<Integer, Integer>>  players = new  HashMap<Integer, Pair<Integer, Integer>>();

    public View() {
        super();

        this.setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.addKeyListener(player);
        this.panel = new Panel();
        this.add(this.panel);
        this.setVisible(true);
    }

    public void updateView(int[][] board,  HashMap<Integer, Pair<Integer, Integer>>  players) {
        this.board = board;
        this.players = players;
        this.repaint();
    }

//    public void clear(int x, int y) {
//        Graphics g = getGraphics();
//        g.setColor(Color.WHITE);
//        g.fillRect(x * width/size, y * width/size, width/size, height/size);
//    }

    private class Panel extends JPanel {
        public Panel() { super(); }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            // call the super class methods, otherwise the background will not be colored
            super.paintComponent(g);

            for (int i = 1; i < board.length-1; i++) {
                for (int j = 1; j < board.length-1; j++) {
                    new Tile(i,j,board[i][j]).draw(g);
                }
            }

            for (Pair<Integer,Integer> par : players.values()) {
                        g.setColor(Color.CYAN);
                        g.fillOval(par.getElement0() * 15, par.getElement1() * 15, 15, 15);
            }

            player.draw(g);
        }
    }
}
