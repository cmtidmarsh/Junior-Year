import javax.swing.*;
import java.rmi.RemoteException;

public class MVCTest {

    /*
        Welcome to Allie's tester class!
        This is just to test how the modified MVC works before we try to
        turn it into a server situation.

        ANDREW: This is how the program must be started now.
                (Note the "generateStart()"!!)

        ALLIE: Yes, generateStart() is nice, perhaps more generate methods could be more nice;
               generateGlider() generateGun() etc.
     */
    public static void main(String[] args) throws RemoteException, InterruptedException {
        Model testModel = new Model();
        testModel.generateStart();


        JFrame board = new JFrame("Board!!!"); //bored
        View theView = new View(testModel.currentState);
        board.add(theView); //so we add the view to our Frame
        board.setVisible(true);//of course we want to see it.
        board.setSize(256, 256);//the size is number of cells 256 x 256
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true) {
            testModel.currentState = testModel.checkRules(testModel.currentState);
            theView.viewState = testModel.currentState;
            theView.update();
            //System.out.println("tick");
            Thread.sleep(50);
        }
    }
}
