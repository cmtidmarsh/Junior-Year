//  C343 / Summer 2020
// Homework - 03
// July 13, 22:50
// Clare Tidmarsh, cmtidmar


import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

public class HW03View extends JComponent {


    private int width;
    private int height;
    private JFrame aJFrame;
    private int[][] array;


    public HW03View(int width, int height){
        array = new int[width][height];
        this.width = width;
        this.height = height;
        JFrame aJFrame = new JFrame();
        aJFrame.add(this);
        aJFrame.setSize(1280, 720);
        aJFrame.setVisible(true);
        aJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // setting a point
    public void drawPoint(int x, int y, int value) {
        array[x][y] = value;
    }

    // getting the point
    public int get(int x, int y){
        int pixel = array[x][y];
        return pixel;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 0, y = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int value = get(x, y); //gets the value of the location

        // for all values in the 2d array
        for (x = 0; x < width; x++) {
            for (y = 0; y < height; y++) {
                value = get(x, y); // get a single pixel

            }
        }
            System.out.println("A single random pixel: " + value);
            if (value >= min && value <= -255) {
                Color background = new Color(255, 0, 0);
                g.setColor(background);
                g.drawOval(x, y, 100, 100);
            } else if (value >= -254 && value <= -1) {
                Color background = new Color((value * (-1)), 0, 0);
                g.setColor(background);
                g.drawOval(x, y, 100, 100);
            } else if (value == 0) {
                Color black = new Color(0, 0, 0);
                g.setColor(black);
                g.drawOval(x, y, 100, 100);
            } else if (value >= 1 && value <= 255) {
                Color background = new Color(0, value, 0);
                g.setColor(background);
                g.drawOval(x, y, 100, 100);
            } else if (value >= 256 && value <= max) {
                Color background = new Color(0, 255, 0);
                g.setColor(background);
                g.drawOval(x, y, 100, 100);
            }
        }


        public static void clear () {
            Graphics pGraphics = null;
            Color lForegroundColor = new Color(0, 0, 0);
            pGraphics.setColor(lForegroundColor);
        }


    // client code - main() method:
    public static void main(String[] args) {
        HW03View theMainJComponent = new HW03View(1280, 720);
        JFrame aJFrame = new JFrame();
        aJFrame.add(theMainJComponent);
        aJFrame.setSize(1280, 720);
        aJFrame.setVisible( true );
        aJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //clear();

    }



}