import javax.swing.*;
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
    JPanel jpanel;

    public View(){
        jpanel = new JPanel(new GridLayout(50, 50));
        jframe = new JFrame("View");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(10, 10, 550, 550);
        jframe.setContentPane(jpanel);
        jframe.setVisible(true);
    }

    //initial Board
    public void makeBoard(int[][] input){
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
                if(input[i][j] == 9) tile = new PlayerDecorator(new TileZero(i, j));
                tile.draw(jframe.getGraphics());

            }
        }
    }

    //redraw board
    public void updateBoard(int[][] input){
        jpanel.removeAll();

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
                // probably going to change this to be >= 8. then once the player moves, instead of setting

                if(input[i][j] > 8) tile = new PlayerDecorator(tile);
                tile.draw(jframe.getGraphics());
            }
        }
//        jpanel.revalidate();
//        jpanel.repaint();
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

    @Override
    public void update(Observable o, Object arg) {
        updateBoard((int[][]) arg);
    }
}