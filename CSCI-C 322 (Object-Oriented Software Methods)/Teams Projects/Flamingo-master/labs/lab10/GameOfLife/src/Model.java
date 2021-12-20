import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

//Right, so we need something that extends the UnicastRemoteObject
public class Model extends UnicastRemoteObject implements ModelInterface, ActionListener {


//    class ModelServer extends UnicastRemoteObject {
//         public ModelServer() throws java.rmi.RemoteException {
//              super();
//	 }
//
//    }


    int state = 0; //0 for false, not 0 for true 1 is alive 0 is dead.
    int x;
    int y;
    //these x and y are actually quite pointless because the index of
    //our array also serves as a point location (pun not intended).
    //I'll keep them just incase I'm mistaken.

    //this can just be an int array
    int[][] currentState = new int[256][256];
    //Timer timer;
    //Controller controller;
    //View theView = new View(currentState);
    //would be better to have a board in the constructor but it's all good.
    Model() throws java.rmi.RemoteException {
        super();
    }
    public void setState(int x, int y, int state) {
        this.currentState[x][y] = state;
    }

    /*
        Generates a starting board
        Starts Timer
        *DOES NOT* Set up Observer  (No longer use observer instead just pull from server constantly
        (Should ONLY be called for initial model.)
     */
    public void generateStart() {
        //yes this is good!
        //change model to int
        int[][] startingState = new int[256][256]; //just an empty state to start with.
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                double index;
                int cellState;
                index = Math.random(); //ok so this generates random
                if (index > 0.5) {
                    cellState = 1;
                } else {
                    cellState = 0;
                }
                startingState[i][j] = cellState;
            }
        }
        this.currentState = startingState;
    }
        /*
        This is an example of a glider
        feel free to comment this out, just make sure to set every state to dead on line 41.
        that is;
             x
           x x
            xx
        it walks in a diagonal.

        startingState[128][128] = 1;
        startingState[129][129] = 1;
        startingState[129][130] = 1;
        startingState[128][130] = 1;
        startingState[127][130] = 1;

        Our implementation supports hardcoding input cells.*/


        //this.timer = new Timer(50, this);
        //this.controller = new Controller(startingState);
        //addObserver(this.controller);
        //timer.start();
    //

//    public Controller getController() {
//        return controller;
//    }

    /*
        Implements the Game of Life by generating the next generation.
     */
    public int[][] checkRules(int[][] state) {
        int[][] newState = new int[256][256];
        //i = y, j = x
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                //calculate how many liveNeighbors the Cell has
                int cellState = state[i][j];//.getState();
                int liveNeighbors = 0;

                if (j > 0) {
                    liveNeighbors += state[i][j - 1];//.getState();
                    if (i > 0) {
                        liveNeighbors += state[i - 1][j - 1];//.getState();
                    }
                    if (i < 255) {
                        liveNeighbors += state[i + 1][j - 1];//.getState();
                    }
                }
                if (j < 255) {
                    liveNeighbors += state[i][j + 1];//.getState();
                    if (i > 0) {
                        liveNeighbors += state[i - 1][j + 1];//.getState();
                    }
                    if (i < 255) {
                        liveNeighbors += state[i + 1][j + 1];//.getState();
                    }
                }
                if (i < 255) {
                    liveNeighbors += state[i + 1][j];//.getState();
                }
                if (i > 0) {
                    liveNeighbors += state[i - 1][j];//.getState();
                }

                if (cellState == 1) { //alive
                    if ((liveNeighbors < 2) || (liveNeighbors > 3)) {
                        //cell dies
                        newState[i][j] = 0;
                    } else {
                        //cell lives
                        newState[i][j] = 1;
                    }
                } else if (cellState == 0) { //dead
                    if (liveNeighbors == 3) {
                        newState[i][j] = 1;
                    } else {
                        newState[i][j] = 0;
                    }
                }
            }
        }
        return newState;
    }

    public int getState() {
        return this.state;
    }

    /*
        Every time Timer ticks, the next generation is called.
        Then we send that next board to the Observer (Controller).
        (There, Controller passes it to View.)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Ended up not needing this.
        //setChanged();
        //System.out.println("tick");
        //this.currentState = checkRules(this.currentState);
        //theView.viewState = this.currentState;
        //this.theView.viewState = this.currentState;
        //this.theView.
        //theView.update();
    }

    public static void main(String[] args) {
        //inspired by the WeatherServer we looked at in class.
        System.setSecurityManager(new SecurityManager());
        try {
            Model Model = new Model();
            Naming.rebind("/Model", Model);
            System.out.println("Let's go! ^_^");
        } catch (Exception e) {
            System.out.println("O_O oh my god! ERROR\n" + e.getMessage());
        }
    }
}
