package Conway;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Scanner;

public class GameOfLifeController implements Observer {
    public GameOfLifeModel model;
    private GameOfLifeView view = new GameOfLifeView();

    public static void main(String[] args) {

//        Random random = new Random();
//
//        try {
//            FileWriter writer = new FileWriter("data.txt");
//
//            for (int i = 0; i < 256; i++) {
//                for (int j = 0; j < 256; j++) {
//                    writer.write(String.valueOf(random.nextInt(2)));
//                }
//                writer.write("\n");
//            }
//
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        GameOfLifeController controller = new GameOfLifeController();
        controller.readFile(new File("data.txt"));
        controller.createView();
        controller.model.addObserver(controller);
    }

    public void createView() {
        final JFrame frame = new JFrame("GameOfLifeFrame");
        frame.setName("GameOfLifeFrame");
        frame.setVisible(true);
        frame.setSize(256, 256);

        JComponent component = new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < 256; i += 1) {
                    for (int j = 0; j < 256; j += 1) {
                        if (model.getBoard()[i][j] == 1) {
                            g.drawRect(i, j, 1, 1);
                        }
                    }
                }
            }
        };
        component.setName("GameOfLifeComponent");

        frame.add(component);
    }

    public void updateView(Graphics g) {
        Frame.getFrames()[0].repaint();
    }

    private void readFile(File file) {
        try {
            Scanner input = new Scanner(file);
            int[][] board = new int[256][256];
            int rowIndex = 0;

            while (input.hasNextLine()) {
                String currentRow = input.nextLine();
                for (int character = 0; character < 256; character += 1) {
                    board[rowIndex][character] = (currentRow.toCharArray()[character] == '0' ? 0 : 1);
                }
                rowIndex += 1;
            }

            model = new GameOfLifeModel();
            model.setBoard(board);

            model.simulateCycle();
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Aborting.");
            System.exit(0);
        }
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an {@code Observable} object's
     * {@code notifyObservers} method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the {@code notifyObservers}
     */
    public void update(Observable o, Object arg) {
        updateView(Frame.getFrames()[0].getGraphics());
    }
}
