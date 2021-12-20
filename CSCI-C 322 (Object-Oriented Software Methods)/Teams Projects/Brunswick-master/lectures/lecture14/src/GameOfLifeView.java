//C322 Lecture 14 Task - Lab08
//Team03
//3-11-21
//Ben Billings (benbilli@iu.edu), Jiahui Chang (chanji@iu.edu), Chris Taddeucci (ctaddeuc@iu.edu)

import javax.swing.*; //import jcomponent
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Color;


public class GameOfLifeView extends JComponent implements ActionListener{

    JFrame aJFrame;
    int amountOfRows;
    int amountOfColumns;
    int[][] arr;


    public GameOfLifeView(){

        this.amountOfRows = 256;
        this.amountOfColumns = 256;
        arr = new int[amountOfColumns][amountOfRows];
        this.aJFrame = new JFrame();
        aJFrame.add(this);
        aJFrame.setSize(amountOfRows, amountOfColumns);
        aJFrame.setVisible(true);


    }

    public void updateGrid(int[][] modelArray){ //takes input from

        arr = modelArray;
        System.out.println("view array");
        System.out.print(arr);


    }


    public void paintComponent(Graphics pGraphics){

        for(int i = 0; i < amountOfColumns; i++){
            for(int j = 0; j < amountOfRows; j++){

                if(arr[i][j] == 1) {
                    pGraphics.setColor(Color.BLACK);
                    pGraphics.drawRect(i, j, 1, 1);
                }
            }
        }
        this.repaint();
    }
    public void actionPerformed(ActionEvent e) {

    }
}
