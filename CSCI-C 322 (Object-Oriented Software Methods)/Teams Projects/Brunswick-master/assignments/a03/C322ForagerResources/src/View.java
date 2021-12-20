import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class View extends JComponent implements Observer {

    private static final int counterTextHeight = 15; // 15 is the height of the counter on the bottom
    private static final int tileSize = 6; // The size of every tile
    private static final int width = tileSize*128+14; // 14 is the offset for size 6, haven't cared to calculate it yet
    private static final int height = tileSize*128+38+counterTextHeight; // 38 is the size of the top bar in Windows 10
    private static final Color ZERO = new Color(224, 224, 224);
    private static final Color ONE = new Color(192, 192, 192);
    private static final Color TWO = new Color(160, 160, 160);
    private static final Color THREE = new Color(128, 128, 128);
    private static final Color FOUR = new Color(96, 96, 96);
    private static final Color FIVE = new Color(64, 64, 64);
    private static final Color SIX = new Color(32, 32, 32);
    private static final Color SEVEN = new Color(0, 0, 0);
    private static final Color ENEMYCOLOR = new Color(255, 0, 0);


    private Player player;
    private int[][] board;
    private HashMap<Integer, Pair<Integer, Integer>> otherPlayerPositions;

    public View(Controller controller, Player player, int[][] board, HashMap<Integer, Pair<Integer, Integer>> otherPlayerPositions) {
        this.player = player;
        this.board = board;
        this.otherPlayerPositions = otherPlayerPositions;
        this.makeObserver(controller);
        setup();
    }

    private void setup() {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(10, 10, width, height);
        window.getContentPane().add(this);
        window.setVisible(true);
        window.addKeyListener(new PlayerMoved(this));
    }

    private Color getColor(int resourceLevel) {

        switch (resourceLevel) {
            case 0: return ZERO;
            case 1: return ONE;
            case 2: return TWO;
            case 3: return THREE;
            case 4: return FOUR;
            case 5: return FIVE;
            case 6: return SIX;
            case 7: return SEVEN;
        }
        return Color.white;
    }

    public void repaint() {

        super.repaint();
    }

    public void paintComponent(Graphics g) {


        int playerX = player.getPosition().getFirst();
        int playerY = player.getPosition().getSecond();

        // Bounds for the screen
        int leftBound = 0;
        int rightBound = 128;
        if (playerX > 127) { leftBound = 128; rightBound = 256; }

        int lowerBound = 0;
        int upperBound = 128;
        if (playerY > 127) { lowerBound = 128; upperBound = 256; }

        // Drawing the board and resources
        // THE ORDER OF THE BOUNDS AND I AND J MATTER!!!!
        for (int i = lowerBound; i < upperBound; i++) {
            for (int j = leftBound; j < rightBound; j++) {
                g.setColor(getColor(board[i][j]));
                g.fillRect(j%128*tileSize, i%128*tileSize, tileSize, tileSize);
                g.drawRect(j%128*tileSize, i%128*tileSize, tileSize, tileSize);
            }
        }


        // Drawing other players
        for (Integer playerID : otherPlayerPositions.keySet()) {

            var curPlayer = otherPlayerPositions.get(playerID);
            int curPlayerX = curPlayer.getFirst();
            int curPlayerY = curPlayer.getSecond();

            if (leftBound <= curPlayerX && rightBound >= curPlayerX && lowerBound <= curPlayerY && upperBound >= curPlayerY) {
                g.setColor(ENEMYCOLOR);
                g.fillRect(curPlayerX%128*tileSize, curPlayerY%128*tileSize, tileSize, tileSize);
                g.drawRect(curPlayerX%128*tileSize, curPlayerY%128*tileSize, tileSize, tileSize);
            }
        }


        // Drawing the player
        g.setColor(player.getColor());
        g.fillOval(playerX%128*tileSize, playerY%128*tileSize, tileSize, tileSize);
        g.drawOval(playerX%128*tileSize, playerY%128*tileSize, tileSize, tileSize);


        // Drawing the resource counter
        g.setColor(Color.BLACK);
        g.drawString("Resources Gathered: " + this.player.getResources() + "    X: " + playerX + "    Y: " + playerY
                + "    ID: " + this.player.getId(), 0, height-42);
    }

    public void makeObserver(Controller observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        ThreePair<Player, int[][], HashMap<Integer, Pair<Integer, Integer>>> newInfo = (ThreePair<Player, int[][], HashMap<Integer, Pair<Integer, Integer>>>) arg;
        player = newInfo.getFirst();
        board = newInfo.getSecond();
        otherPlayerPositions = newInfo.getThird();
        repaint();
    }

    class PlayerMoved implements KeyListener {
        private View view;

        public PlayerMoved(View view) {
            this.view = view;
        }

        public void keyTyped(KeyEvent e) {}

        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_UP){
                int playerX = player.getPosition().getFirst();
                int playerY = player.getPosition().getSecond();
                boolean ableToMove1 = true;
                boolean ableToMove2 = true;
                for (Integer i : otherPlayerPositions.keySet()){
                    if(playerX == otherPlayerPositions.get(i).getFirst()) {
                        System.out.println("First Loop");
                        ableToMove1 = false;
                    }
                    if(playerY - 1 == otherPlayerPositions.get(i).getSecond()){
                        ableToMove2 = false;
                    }
                }
                if(ableToMove1 || ableToMove2){
                    player.moveUp();
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN){
                int playerX = player.getPosition().getFirst();
                int playerY = player.getPosition().getSecond();
                boolean ableToMove1 = true;
                boolean ableToMove2 = true;
                for (Integer i : otherPlayerPositions.keySet()){
                    if(playerX == otherPlayerPositions.get(i).getFirst()) {
                        ableToMove1 = false;
                    }
                    if(playerY + 1 == otherPlayerPositions.get(i).getSecond()){
                        ableToMove2 = false;
                    }
                }
                if(ableToMove1 || ableToMove2){
                    player.moveDown();
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_LEFT){
                int playerX = player.getPosition().getFirst();
                int playerY = player.getPosition().getSecond();
                boolean ableToMove1 = true;
                boolean ableToMove2 = true;
                for (Integer i : otherPlayerPositions.keySet()){
                    if(playerX - 1 == otherPlayerPositions.get(i).getFirst()) {
                        System.out.println("First Loop");
                        ableToMove1 = false;
                    }
                    if(playerY == otherPlayerPositions.get(i).getSecond()){
                        System.out.println("Same X Value");
                        ableToMove2 = false;
                    }
                }
                if(ableToMove1 || ableToMove2){
                    player.moveLeft();
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                int playerX = player.getPosition().getFirst();
                int playerY = player.getPosition().getSecond();
                boolean ableToMove1 = true;
                boolean ableToMove2 = true;
                for (Integer i : otherPlayerPositions.keySet()){
                    if(playerX + 1== otherPlayerPositions.get(i).getFirst()) {
                        System.out.println("First Loop");
                        ableToMove1 = false;
                    }
                    if(playerY == otherPlayerPositions.get(i).getSecond()){
                        System.out.println("Second Loop");
                        ableToMove2 = false;
                    }
                }
                if(ableToMove1 || ableToMove2){
                    player.moveRight();
                }
            }
            view.repaint();
        }

        public void keyReleased(KeyEvent e) {}

    }

    // Testing
    private View(int[][] board, Player player) {
        this.player = player;
        this.board = board;
        var testPlayers = new HashMap<Integer, Pair<Integer, Integer>>();
        testPlayers.put(0, new Pair<>(1, 1));
        testPlayers.put(1, new Pair<>(5, 5));
        testPlayers.put(2, new Pair<>(100, 100));
        testPlayers.put(3, new Pair<>(250, 240));
        testPlayers.put(4, new Pair<>(69, 96));
        this.otherPlayerPositions = testPlayers;
        setup();
    }
    public static void main(String[] args) {

        int[][] board = new int[256][256];
        try {

            Scanner sc = new Scanner(new File("H:\\Documents\\C322\\Brunswick\\assignments\\a03\\C322ForagerResources\\initial-board.txt"));
            for (int i = 0; i < 256; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < 256; j++) {
                    board[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: initial-board.txt cannot be opened");
        }

        Player player = new ConcretePlayer(0, 10, 10);
        View view = new View(board, new BluePlayer(player));
    }
}
