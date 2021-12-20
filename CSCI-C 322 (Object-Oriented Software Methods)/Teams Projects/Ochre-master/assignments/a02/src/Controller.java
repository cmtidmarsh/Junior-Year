import java.awt.*;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;

public class Controller{
    public ForagerModel model;
    public View view;
    public Player player;
    public int[][] board;
    public Timer timer;
    public HashMap<Integer, Point> playerPositions = new HashMap<Integer,Point>();

    public Controller(View view, ForagerModel model){
        this.model = model;
        this.view = view;


        //ths is for testing
        this.board = new int[10][10];
    }



    //implement this
    public static void main(String[] args) {
        Player player = new Player(0,0,0);
        View view = new View(player);
        ForagerModel model = new ForagerModel();
        Controller controller = new Controller(view, model);

        model.registerPlayer(player);
        model.getPlayerPositions(player.getId());

        //initial setup of board
        view.setBoard(controller.board);

        while(true){
            model.getPlayerPositions(player.getId());
            //setting the position of the player
            view.updatePosition(player.getPosition(), model.getPlayerPositions(player.getId()));

            // setting the position of the other players
            view.drawBoard();
        }

    }



}
