import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

    JFrame jframe;
    JFrame scoreFrame;
    JPanel jpanel;
    JPanel scorePanel;
    JLabel scoreLabel;
    int playerScore;



    public View(){
        jpanel = new JPanel(new GridLayout(101, 100));
        jframe = new JFrame("View");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(10, 10, 1100, 1300);

        scoreFrame = new JFrame("PlayerScore");
        scorePanel = new JPanel(new GridLayout(1,1));
        scoreFrame.add(scorePanel);
        scoreLabel = new JLabel("Player Score: "+String.valueOf(playerScore));
        scorePanel.add(scoreLabel);
        scoreFrame.setSize(300,100);
        scoreFrame.setVisible(true);

        //playerScore.setLocation(500,500);
        jframe.add(jpanel);
        jframe.setVisible(true);

    }

    //initial Board
    public void makeBoard(int[][] input){
        scoreLabel.setText("Player Score: "+String.valueOf(playerScore));
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input[0].length; j++){
                Tile tile = new TileZero(i, j);
                if (input[i][j] == 1) tile = new TileOne(i, j);
                if (input[i][j] == 2) tile = new TileTwo(i, j);
                if (input[i][j] == 3) tile = new TileThree(i, j);
                if (input[i][j] == 4) tile = new TileFour(i, j);
                if (input[i][j] == 5) tile = new TileFive(i, j);
                if (input[i][j] == 6) tile = new TileSix(i, j);
                if (input[i][j] == 7) tile = new TileSeven(i, j);
                if(input[i][j] == 9) tile = new PlayerDecorator(new TileZero(i, j),Color.BLACK);
                tile.draw(jframe.getGraphics());

            }
        }
        jpanel.add(scorePanel);

        scorePanel.setVisible(true);


    }

    //redraw board
    public void updateBoard(int[][] input){
        jpanel.removeAll();
        scoreLabel.setText("Player Score: "+String.valueOf(playerScore));

        for(int i = 0 ; i < input.length; i++){
            for(int j = 0; j < input[0].length; j++){
                Tile tile = new TileZero(i, j);
                if (input[i][j] == 1) tile = new TileOne(i, j);
                if (input[i][j] == 2) tile = new TileTwo(i, j);
                if (input[i][j] == 3) tile = new TileThree(i, j);
                if (input[i][j] == 4) tile = new TileFour(i, j);
                if (input[i][j] == 5) tile = new TileFive(i, j);
                if (input[i][j] == 6) tile = new TileSix(i, j);
                if (input[i][j] == 7) tile = new TileSeven(i, j);

                // player is on a tile
                if(input[i][j] > 8 && input[i][j] < 20) tile = new PlayerDecorator(tile, Color.BLACK);

                //two players are on the same tile
                if(input[i][j] >=20) {
                    tile = new PlayerDecorator(tile, Color.BLUE);
                }

                //
                tile.draw(jframe.getGraphics());
            }
        }
        jpanel.add(scorePanel);
        scoreFrame.add(scorePanel);
        scoreFrame.repaint();
        jpanel.setVisible(true);




//        jpanel.revalidate();

    }

    public JFrame getJframe() { return jframe; }

    public static void main(String[] args) {
        int[][] board = new int[50][50];
        int max = 2;
        int min = 0;
        int range = max - min + 1;
        for (int i = 0; i < board[0].length; i++)
            for (int j = 0; j < board.length; j++)
                board[i][j] = (int) (Math.random() * range) + min;
        board[25][25] = 9;
        View view = new View();
        view.makeBoard(board);

    }

    public void setPlayerScore(int score){
        this.playerScore = score;
    }

    @Override
    public void update(Observable o, Object arg) {
        updateBoard((int[][]) arg);
    }
}