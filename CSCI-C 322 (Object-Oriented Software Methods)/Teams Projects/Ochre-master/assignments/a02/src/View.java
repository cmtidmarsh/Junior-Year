import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;

public class View extends JComponent implements KeyListener {
    public JFrame frame = new JFrame("Forager");
    public Dimension screenDim = new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight(), (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth());
    private String lastInput;
    private Player player;
    private int[][] gameboard;
    // the array relating only to the positions of the players
    private int[][] playerBoard;


    public View(Player player){
        // setting a default value for the game board.
        this.gameboard = new int[1][1];
        this.playerBoard = gameboard;
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(screenDim);
        frame.pack();

        frame.setVisible(true);
        this.lastInput = "x";

        this.player = player;
    }

    //updates the current players position
    public void updatePosition(Point playerPosition, ArrayList<Point> otherPlayers){
        // resetting the game board. This removes the old moves of the players
        playerBoard = new int[gameboard.length][gameboard.length];
        this.playerBoard[playerPosition.x][playerPosition.y] = -1;

        for(int i = 0; i < otherPlayers.size(); i +=1){
            Point curOtherPlayer = otherPlayers.get(i);
            this.playerBoard[curOtherPlayer.x][curOtherPlayer.y] = -2;
        }
    }

    public void  sendPlayerMovements(Player player){

    }
    public void gatherResources(){}

    // changed from getBoard to setBoard
    public void setBoard(int[][] newBoard){

        this.gameboard = newBoard;
        playerBoard = gameboard;
    }

    public void drawBoard() {

        this.repaint();

    }

    public void paintComponent(Graphics g){

        for(int row = 0; row < gameboard.length; row += 1){
            for(int col = 0; col < gameboard.length; col += 1){
                g.setColor(Color.BLACK);
                g.drawRect(row * 10, col * 10, 10, 10 );
                g.fillRect(row * 10, col * 10, 10, 10 );

                // -1 relates to the this player (the player who has this view)
                if(playerBoard[row][col] == -1){
                    g.setColor(Color.BLUE);
                    g.drawRect(row * 10, col * 10, 10, 10 );
                    g.fillRect(row * 10, col * 10, 10, 10 );
                }

                //-2 relates to the other players (players using other views)
                else if(playerBoard[row][col] == -2){
                    g.setColor(Color.RED);
                    g.drawRect(row * 10, col * 10, 10, 10 );
                    g.fillRect(row * 10, col * 10, 10, 10 );
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.setPosition(Character.toString(e.getKeyChar()));
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //new
    public String getLastInput(){
        return this.lastInput;
    }

    public void resetInput(){
        this.lastInput = " ";
    }
}
