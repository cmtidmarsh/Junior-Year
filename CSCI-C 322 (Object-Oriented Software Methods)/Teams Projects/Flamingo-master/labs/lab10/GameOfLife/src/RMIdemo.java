import javax.swing.*;
import java.rmi.*;
import java.util.Observable;
import java.util.Observer;

public class RMIdemo {
    //Inspired from the WeatherServer we looked at.
    public static void main(String[] args) {
        try {

            Remote robj = Naming.lookup("//localhost/Model");
            ModelInterface Model = (ModelInterface)robj;
            //int[][] start = new int[256][256];
            Model model = new Model();
            model.generateStart();
            View theView = new View(model.currentState);//view is SEPERATE from the model which is important.
            //controller is not needed, if anything this is the controller
            JFrame board = new JFrame("Board"); //bored
            board.add(theView); //so we add the view to our Frame
            board.setVisible(true);//of course we want to see it.
            board.setSize(256, 256);//the size is number of cells 256 x 256
            board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //things that we want to try
            while(true) {
                //instead of messing with Observ/er/able just gonna update it every 50 millis
                model.currentState = model.checkRules(model.currentState);
                theView.viewState = model.currentState;
                theView.update();
                Thread.sleep(50);

            }
        } catch (Exception e)   {
            System.out.println(e.getMessage());
        }

    }
}
