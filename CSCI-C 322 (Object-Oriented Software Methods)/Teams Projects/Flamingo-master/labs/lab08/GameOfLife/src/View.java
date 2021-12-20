import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
//Ah, interesting we have observable pointing from View but I think we actually mean Observer.
//It seems that we needed both on the UML but we only had the one.
//A shame.
public class View extends JPanel implements Observer {
    //keeping track of board state.
    Cell startingState[][] = new Cell[256][256];






    public void implementBoardTxt() {
        //so this must be for printing out the board to console?
        int i;
        int j;
        int k; //current cell - ended up not using this.
        for(i = 0; i < 256; i++) {
            System.out.print("\n");
            for(j = 0; j < 256; j++) {
                System.out.print(startingState[i][j].getState());

            }
        }

    }

    public void start() {
        System.out.println("We are starting! yipee!!!");
    }

    public void mousePressed(int delat, int size) {
        System.out.println("Mouse pressed");
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed!");
    }
    @Override
    protected void paintComponent(Graphics g) {
        //System.out.println("GIVE ME A SIGN PLEASE!"); //I was starting to get desperate heheh
        super.paintComponent(g);
        //we want to iterate through the state and draw each pixel.
        for(int i = 0; i < 256; i++) {
         for(int j = 0; j < 256; j++) {
             if(startingState[i][j].getState() == 1) {
                 //when it's 1 it is alive
                 //LET THERE BE LIFE.
                 g.setColor(Color.black);
                 g.fillRect(i, j, 1, 1);
             } else {
                 //when it isn't 1 it is dead (so sad).
                 g.setColor(Color.white);
                 g.fillRect(i, j, 1, 1);
             }
          }
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        repaint();
        //using our observer method! :)
        //this just paints the scene again.
    }
}
