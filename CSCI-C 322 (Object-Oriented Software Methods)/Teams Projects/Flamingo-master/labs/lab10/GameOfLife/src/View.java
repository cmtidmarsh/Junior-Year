import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
//Ah, interesting we have observable pointing from View but I think we actually mean Observer.
//It seems that we needed both on the UML but we only had the one.
//A shame.
public class View extends JPanel {
    //keeping track of board state.
    int[][] viewState = new int[256][256];

    public View(int[][] state){
//        for(int i = 0; i < 256; i++) {
//            for(int j = 0; j < 256; j++) {
//                this.viewState[i][j] = state[i][j];
//            }
//        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        //System.out.println("GIVE ME A SIGN PLEASE!"); //I was starting to get desperate heheh
        super.paintComponent(g);
        //we want to iterate through the state and draw each pixel.
        for(int i = 0; i < 256; i++) {
         for(int j = 0; j < 256; j++) {
             if(viewState[i][j] == 1) {
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

    public void update() {
        this.repaint();
        //System.out.println("tock");
        //this just paints the scene again.
    }
}
