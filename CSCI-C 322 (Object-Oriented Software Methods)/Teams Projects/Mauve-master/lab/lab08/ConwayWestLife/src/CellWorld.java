import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CellWorld extends JComponent{
    int cellRow = 256;
    int cellCol = 256;

    public void initialize(){
        board = new Cell[cellRow][cellRow];
        JFrame frame = new JFrame();
        frame.add( this );
        frame.setSize(cellCol, cellCol);

        JComponent component = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);
            }
        };

        frame.add(component);
        frame.setVisible(true);

        Random generator = new Random();
        for (Cell[] row : board) {
            for (int i = 0; i < row.length; i++) {
                int coinToss = generator.nextInt(100);
                //alive
                if(coinToss < 30){
                    LiveCell liveCell = new LiveCell();
                    liveCell.update();
                    row[i] = liveCell;
                }else{
                    row[i] = new DeadCell();
                }
            }


        }
    }

    Cell[][] board;
    protected void draw(Graphics g) {
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                Cell current = board[i][j];
                //alive
                if(current.lifeState == 1){
                    g.setColor(Color.green);
                }else{
                    g.setColor(Color.red);
                }
                g.drawRect(i, j, 1, 1);
            }
        }
    }

    public void repaint(){

    }

    public Cell[] getCells(){
        return null;
    }

    public static void main(String[] args) {
        CellWorld world = new CellWorld();
        world.initialize();
    }
}
