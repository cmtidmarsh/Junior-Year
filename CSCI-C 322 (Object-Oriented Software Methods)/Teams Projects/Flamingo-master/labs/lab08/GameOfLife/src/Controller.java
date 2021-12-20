import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Observable;

//poor deprecated observable, some one still loves u
public class Controller extends Observable implements ActionListener {
    Cell[][] currentState;
    Cell[][] nextState;
    Timer timer;
    int count;
    View theView;


    public Controller(Cell[][] currentState){
        this.theView = new View();
        this.currentState = currentState;
        this.timer = new Timer(50, this);
        this.timer.start();
        this.count = 0;
        addObserver(this.theView);
    }

    public static void main(String[] args) {
        Cell[][] startingState = new Cell[256][256]; //just an empty state to start with.
        Controller controller = new Controller(startingState);
        for(int i = 0; i < 256; i++) {
            for(int j = 0; j < 256; j++) {
                double index;
                int state;
                index = Math.random(); //ok so this generates random
                if(index > 0.5) {
                    state = 1;
                } else {
                    state = 0;
                }

                controller.theView.startingState[i][j] = new Cell(state, i, j); //modify 'state' to '0' to allow hardcoding input cells.

            }
        }
//        This is an example of a glider
//        feel free to comment this out, just make sure to set every state to dead on line 41.
//        that is;
//             x
//           x x
//            xx
//        it walks in a diagonal.

//        controller.theView.startingState[128][128] = new Cell(1, 2, 1);
//        controller.theView.startingState[129][129] = new Cell(1, 2, 1);
//        controller.theView.startingState[129][130] = new Cell(1, 2, 1);
//        controller.theView.startingState[128][130] = new Cell(1, 2, 1);
//        controller.theView.startingState[127][130] = new Cell(1, 2, 1);

//        our implementation supports hardcoding input cells.

//        Setting up the board.

        JFrame board = new JFrame("Board!!!"); //bored
        board.add(controller.theView); //so we add the view to our Frame
        board.setVisible(true);//of course we want to see it.
        board.setSize(256, 256);//the size is number of cells 256 x 256
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//and please stop running

    }

    public Cell[][] checkRules(Cell[][] state){
        Cell[][] newState = new Cell[256][256];
        //i = y, j = x
        for (int i = 0; i < 256; i++){
            for (int j = 0; j < 256; j++){
                //calculate how many liveNeighbors the Cell has
                int cellState = state[i][j].getState();
                int liveNeighbors = 0;


                if (j > 0){
                    liveNeighbors += state[i][j-1].getState();
                    if (i > 0){
                        liveNeighbors += state[i-1][j-1].getState();
                    }
                    if (i < 255){
                        liveNeighbors += state[i+1][j-1].getState();
                    }
                }
                if (j < 255){
                    liveNeighbors += state[i][j+1].getState();
                    if (i > 0){
                        liveNeighbors += state[i-1][j+1].getState();
                    }
                    if (i < 255){
                        liveNeighbors += state[i+1][j+1].getState();
                    }
                }
                if (i < 255){
                    liveNeighbors += state[i+1][j].getState();
                }
                if (i > 0){
                    liveNeighbors += state[i-1][j].getState();
                }

                if (cellState == 1){ //alive
                    if ((liveNeighbors < 2) || (liveNeighbors > 3)){
                        //cell dies
                        newState[i][j] = new Cell(0, i, j);
                    } else {
                        //cell lives
                        newState[i][j] = new Cell(1, i, j);
                    }
                } else if (cellState == 0){ //dead
                    if (liveNeighbors == 3){
                        newState[i][j] = new Cell(1, i, j);
                    } else {
                        newState[i][j] = new Cell(0, i, j);
                    }
                }
            }
        }
        return newState;
    }

    public Cell[][] sendBoards(){
        return currentState;
    }

    public void meh(MouseEvent e){
        //Empty, no use
    }

    public void keh(KeyEvent e){
        //Empty, no use
    }

    public void draw(Graphics g){
        //Empty, no use
    }

    public boolean hasEnded(){
        //Empty, no use
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //every time timer ticks, make a new state and let View know
        this.theView.startingState = checkRules(theView.startingState);
        setChanged();
        notifyObservers();
    }

}
