import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class View extends JFrame {
    public static int WIDTH = 1024;
    public static int HEIGHT = 1024;

    Player player;
    int idTracker = 0;
    private Panel panel;
    int[][] board = new int[50][50];
    ArrayList<Player> players = new ArrayList<Player>();
    int timeLeft = 10 * 60;
    int score = Model.SCORE;

    public View() {
        super();
        this.setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.addKeyListener(player);
        this.panel = new Panel();
        this.add(this.panel);
        this.setVisible(true);
        player = new Player(idTracker);
        players.add(player);
        idTracker++;
    }

    public void updateView(int[][] board,  ArrayList<Player> players, long timePassed) {
        this.board = board;
        this.players = players;
        bouncePlayer();

        this.timeLeft = ((10 * 60) - (int) timePassed);
        this.repaint();
    }

    public void bouncePlayer(){
        for(int i=0; i< players.size();i++){
            for(int j= i+1; j< players.size()-1; j++){
                int currPlayerX = players.get(i).positionX;
                int currPlayerY = players.get(i).positionY;
                int nextPlayerX = players.get(j).positionX;
                int nextPlayerY = players.get(j).positionY;
                if(currPlayerX == nextPlayerX && currPlayerY == nextPlayerY){
                    double rand = Math.random();
                    if (rand < 0.5){
                        players.get(i).setPosition(currPlayerX+1,currPlayerY-1);
                    }
                    else{
                        players.get(j).setPosition(nextPlayerX+1,nextPlayerY-1);
                    }
                }
            }
        }
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



            for(Player p: players){
                g.setColor(Color.cyan);
                g.fillOval(p.positionX, p.positionY, 15, 15);
            }

            // draw timer

            int secondsLeft = timeLeft % 60;
            int minutesLeft = timeLeft / 60;
            g.drawString("Time Remaining... " + String.valueOf(minutesLeft) + " : " + String.valueOf(secondsLeft), 20, 10);
           
            // draw score
            g.drawString("Score: " + player.collectedResources, 690, 10);

            if (timeLeft == 1) {
                g.setColor(Color.black);
                g.fillRect(0,0,getWidth(), getHeight());
                g.setColor(Color.white);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
                g.drawString("GAME OVER. Your Score: " + String.valueOf(score), getWidth()/2, getHeight());
            }


            // draw the player
            player.draw(g);


        }
    }
}
