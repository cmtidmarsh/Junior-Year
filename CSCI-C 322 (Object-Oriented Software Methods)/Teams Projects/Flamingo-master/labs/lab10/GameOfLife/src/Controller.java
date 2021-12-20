import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
//ended up not using Controller
public class Controller implements Observer {
    View theView;

    public Controller(int[][] currentState){
        this.theView = new View(currentState);
    }

    /*
        Called from Model, meaning there is a new board to show.
        Then sets the board in View.
        Then calls View's update() function so it can represent the new board.
     */
    @Override
    public void update(Observable o, Object arg) {
        //theView.startingState = (int[][]) arg;
        theView.update();
    }
}
