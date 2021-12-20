

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import static java.awt.Color.*;

public class GameOfLifeView extends JComponent {

    JFrame aJFrame;
    Graphics g2;

    public GameOfLifeView(){
        aJFrame = new JFrame();
        aJFrame.add(this);
        aJFrame.setSize(259, 287);
        aJFrame.setVisible(true);
        aJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void drawSquare(int x,int y, Color c){
        g2 = getGraphics();
        g2.setColor(c);
        g2.fillRect(x, y, 1, 1);
    }

    public void display(boolean[][] grid){
        for(int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == true) {
                    drawSquare(i, j, WHITE);
                } else {
                    drawSquare(i, j, BLACK);
                }
            }
        }
    }
}
