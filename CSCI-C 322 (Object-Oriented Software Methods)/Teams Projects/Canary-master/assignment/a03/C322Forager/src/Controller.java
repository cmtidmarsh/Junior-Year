
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.io.WriteAbortedException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnmarshalException;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Controller extends Observable implements KeyListener, Serializable {
    ForagerInterface model;
    View view;
    Player player;
    int[][] board;
    TimerTask task;
    Boolean hasMoved;

    HashMap<Integer, Pair<Integer, Integer>> playerPositions ;
    int seconds = 1;

    Controller(ForagerInterface model) {
        this.view = new View();
        view.getJframe().addKeyListener(this);
        this.player = new Player(25, 25, 0); //Starts the player at the center of the map with 0 resources
        this.model = model;
        this.hasMoved = false;
        addObserver(view);


        try {
            this.board = model.getResources();
            playerPositions = model.getPlayerPositions(this.player.getID());
            Pair<Integer, Integer> position = this.player.getPosition();
            this.model.sendPlayerPosition(this.player.getID(), (int)position.getFirst(), (int)position.getSecond());

            startTimer();

            //Add player positions into the board
            try {
                for(Pair value: playerPositions.values()){
                    board[(int) value.getFirst()][(int)value.getSecond()] = 9;
                }
            }
            catch(IndexOutOfBoundsException iobe){

            }
            board[25][25] = 9;

            view.makeBoard(board);
        }
        catch(java.rmi.RemoteException re){ System.out.println(re); }
    }

    public void startTimer(){

    }

    public int getSeconds(){
        return this.seconds;
    }

    public static void main(String[] args) throws RemoteException{
        Controller c = null;

        try {
            System.out.println("Tried");
            Remote robj = Naming.lookup("//localhost/Model");
            System.out.println("Object gotten from remote");
            ForagerInterface model = (ForagerInterface)robj;
            System.out.println("Object created");

            c = new Controller(model);

            System.out.println("Object passed to constructor");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("here's the exception?");
            System.out.println(e);
        }
        updateBoard(c);

    }

    public static void updateBoard(Controller c){
        c.board[c.player.getPosition().getFirst()][c.player.getPosition().getSecond()] += 10;
        c.view.updateBoard(c.board);

        // players have to wait 5 seconds to input and update their board
        while(true){
            try {
                c.hasMoved = false;
                //Communicates with the model
                Pair<Integer, Integer>  position = c.player.getPosition();

                //System.out.println("resources: "+ c.player.getResources());

                c.model.sendPlayerPosition(c.player.getID(), (int) position.getFirst(), (int) position.getSecond());
                c.board = c.model.getResources();
                c.playerPositions = c.model.getPlayerPositions(c.player.getID());

                // collecting all of the resources at that tile
                //System.out.println(c.board[position.getFirst()][position.getSecond()]);
                if(c.board[position.getFirst()][position.getSecond()] > 10){
                    c.player.setResources(c.board[position.getFirst()][position.getSecond()] - 10);
                    c.model.gatherResource(c.player.getID());
                }

                //Add player positions/movements into the board
                try {
                    for(Pair value: c.playerPositions.values()){
                        c.board[(int) value.getFirst()][(int)value.getSecond()] = 9;
                    }
                    c.model.setResources(c.board);
                }
                catch(IndexOutOfBoundsException iobe){ }

                //Updates the view
                c.view.setPlayerScore(c.player.getResources());
                c.view.updateBoard(c.board);
                Thread.sleep(5000);
            }
            catch (InterruptedException | RemoteException a){
                System.out.println("oops");
            }

        }


    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        //Player movement
        int key = e.getKeyCode();
        Pair<Integer, Integer>  position = player.getPosition();

        // need to do some check to make sure that players cannot move more than once.

        if (key == KeyEvent.VK_W && this.hasMoved == false){
            this.hasMoved = true;
            board[(int) position.getFirst()][(int) position.getSecond()] -= 10;
            if(board[(int) position.getFirst()][(int) position.getSecond()] < 0){
                board[(int) position.getFirst()][(int) position.getSecond()] = 0;
            }
            board[(int) position.getFirst()][(int) position.getSecond() - 1] += 10;
            player.setPosition(position.getFirst(), position.getSecond() - 1);
            try {
                model.setResources(board);
            } catch (RemoteException remoteException) { }
            notifyObservers(board);
        }
        if(key == KeyEvent.VK_A && this.hasMoved == false){
            this.hasMoved = true;
            // this is where the position that the player is moving away from is reset. current plan is to set this to board position - 10. resetting it to the original value
            board[(int) position.getFirst()][(int) position.getSecond()] -=  10;

            if(board[(int) position.getFirst()][(int) position.getSecond()] < 0){
                board[(int) position.getFirst()][(int) position.getSecond()] = 0;
            }
            //setting the position where the player is moving to to 9. current plan is to instead add 10 to that number
            board[(int) position.getFirst()-1][(int) position.getSecond()] += 10 ;
            player.setPosition(position.getFirst() - 1, position.getSecond());
            try {
                model.setResources(board);
            } catch (RemoteException remoteException) { }
            notifyObservers(board);
        }
        if(key == KeyEvent.VK_D && this.hasMoved == false){
            this.hasMoved = true;
            board[(int) position.getFirst()][(int) position.getSecond()] -= 10;

            if(board[(int) position.getFirst()][(int) position.getSecond()] < 0){
                board[(int) position.getFirst()][(int) position.getSecond()] = 0;
            }
            board[(int) position.getFirst() + 1][(int) position.getSecond()] += 10;
            player.setPosition(position.getFirst() + 1, position.getSecond());
            try {
                model.setResources(board);
            } catch (RemoteException remoteException) { }
            notifyObservers(board);
        }
        if(key == KeyEvent.VK_S && this.hasMoved == false){
            this.hasMoved = true;
            board[(int) position.getFirst()][(int) position.getSecond()] -= 10;

            if(board[(int) position.getFirst()][(int) position.getSecond()] < 0){
                board[(int) position.getFirst()][(int) position.getSecond()] = 0;
            }
            board[(int) position.getFirst()][(int) position.getSecond() + 1] += 10;
            player.setPosition(position.getFirst(), position.getSecond() + 1);
            try {
                model.setResources(board);
            } catch (RemoteException remoteException) { }
            notifyObservers(board);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}