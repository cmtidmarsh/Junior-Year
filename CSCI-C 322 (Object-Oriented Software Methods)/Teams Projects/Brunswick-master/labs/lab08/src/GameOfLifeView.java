//C322 Lecture 14 Task - Lab08
//Team03
//3-11-21
//Ben Billings (benbilli@iu.edu), Jiahui Chang (chanji@iu.edu), Chris Taddeucci (ctaddeuc@iu.edu)

import javax.swing.*; //import jComponent
import java.awt.Graphics;
import java.awt.Color;

public class GameOfLifeView extends JComponent{

    JFrame aJFrame;
    int amountOfRows;
    int amountOfColumns;
    int[][] arr;

    public GameOfLifeView(){
        amountOfRows    = 256;
        amountOfColumns = 256;
        arr = new int[amountOfColumns][amountOfRows];
        aJFrame = new JFrame("Game Of Life");
        aJFrame.add(this);
        aJFrame.setVisible(true);
        aJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        aJFrame.setSize(amountOfRows * 3, amountOfColumns * 3);
    }

    public void drawNewArr(int[][] arr) {
        this.arr = arr;
        paintComponent(getGraphics());
    }

    public void paintComponent(Graphics pGraphics) {

        int rP3 = 0;
        int cP3 = 0;

        for (int row = 0; row < amountOfRows; row++) {
            for (int column = 0; column < amountOfColumns; column++) {
                if (arr[row][column] == 1) {
                    pGraphics.setColor(Color.BLACK);
                }else {
                    pGraphics.setColor(Color.WHITE);
                }
                pGraphics.fillRect(rP3, cP3, 3, 3);
                cP3 += 3;
            }
            rP3 += 3;
            cP3 =  0;
        }
    }
}