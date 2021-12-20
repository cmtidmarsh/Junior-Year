import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

public class View extends Observable {

    // For implementation of the Singleton Pattern
    private static View INSTANCE = null;
    public static View getInstance() {
        if (INSTANCE == null) {
            synchronized (View.class) {
                if (INSTANCE == null) {
                    INSTANCE = new View();
                }
            }
        }
        return INSTANCE;
    }

    // From the previous team
    public Panel panel;
    public JFrame frame;
    public int[][] grid;
    public HashMap<Integer, Pair<Integer, Integer>> players;
    public int playerID;
    public int score;
    // The height reserved for the status bar in the top left of the view; added to every y value that is painted
    public int topBarOffset = 25;

    // From the previous team's implementation
    private View() {
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

    // Updates the state of the game shown in the View
    public void updateView(int[][] grid, HashMap<Integer, Pair<Integer, Integer>> players,
                           int score) {
        this.grid = grid;
        this.players = players;
        this.score = score;
        this.frame.repaint();
    }

    private class Panel extends JPanel {
        public Panel() { super(); }

        @Override
        public void paintComponent(Graphics g) {

            // call the super class methods, otherwise the background will not be colored
            super.paintComponent(g);

            // Used for game timer
            int gameLength  = players.get(-13).getX(); // -13 is the id for the game timer
            int elapsedTime  = players.get(-13).getY();

            if (elapsedTime > gameLength) {
                g.setColor(Color.RED);
                g.drawString("Final Score: " + score, 10, 20);
            }
            else {
                // Implementation taken from previous team but the colors were changed to show differences in resource levels easier.
                for (int i = 1; i < 257; i++) {
                    for (int j = 1; j < 257; j++) {
                        if(grid[i][j]==0) g.setColor(Color.WHITE);
                        else if (grid[i][j]==1) g.setColor(new Color(179, 225, 172));
                        else if (grid[i][j]==2) g.setColor(new Color(158, 207, 141));
                        else if (grid[i][j]==3) g.setColor(new Color(133, 196, 120));
                        else if (grid[i][j]==4) g.setColor(new Color(109, 185, 102));
                        else if (grid[i][j]==5) g.setColor(new Color(81, 164, 82));
                        else if (grid[i][j]==6) g.setColor(new Color(58, 153, 68));
                        else g.setColor(new Color(24, 134, 45));
                            g.fillOval(i * 10 - 10, topBarOffset+(j * 10 - 10), 10, 10);

                        g.setColor(Color.BLACK);
                        g.drawOval(i * 10 - 10, topBarOffset+(j * 10 - 10), 10, 10);
                    }
                }

                // Draw all of the players
                for (int id : players.keySet()) {
                    // -13 is the game information and should not be drawn
                    if (id != -13) {
                        if (id != playerID) g.setColor(Color.black);
                        else g.setColor(Color.red);
                        g.fillRect(players.get(id).getX(), topBarOffset + players.get(id).getY(), 10, 10);
                    }
                }


                // Drawing the time information on the top bar
                long secondsLength = (gameLength / 1000) % 60;
                long minutesLength = (gameLength / (1000 * 60)) % 60;
                long secondsElapsed = (elapsedTime / 1000) % 60;
                long minutesElapsed = (elapsedTime / (1000 * 60)) % 60;
                String gameInfo = String.format("Game length: %d:%02d     Time elapsed: %d:%02d     " +
                                "Score: %d",
                        minutesLength, secondsLength, minutesElapsed,
                        secondsElapsed, score);

                g.setColor(Color.RED);
                g.drawString(gameInfo, 5, 16);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // This is from the previous team but does not serve any functional purpose in this program so we left it alone
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
        x.updateView(y,z,0);
        TimeUnit.SECONDS.sleep(5);
        z.replace(0, new Pair<Integer, Integer>(30,30));
        y[1][1] = 0;
        x.updateView(y,z,0);
    }
}
