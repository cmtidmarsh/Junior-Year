
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
// C343 / SUMMER 2020
// HOMEWORK - 04
//JULY 19, 2020 20:36
// Clare Tidmarsh, cmtidmar

import javax.swing.JComponent;
import javax.swing.JFrame;

public class HW04View extends JComponent {
    private int width;
    private int height;
    private JFrame frame;
    private ArrayList<Pixel> pixels = new ArrayList<Pixel>();
    public static final int size = 5; // sets the size of the pixel
    // A class for an individual pixel
    private class Pixel {
        public int x; // x coordinate
        public int y; // y coordinate
        public int r; // RGB : red
        public int g; // RGB : green
        public int b; // RGB : blue

        // An individual pixel takes in the parameters of x coordinate, y coordinate, and a RGB color
        public Pixel(int x, int y, int r, int g, int b) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
    // Viewer takes a width a screen and a height
    public HW04View(int width, int height) {
        this.width = width; // width of screen
        this.height = height; // height of screen
        frame = new JFrame(); // create a JFrame
        frame.add(this); // add to JFrame i.e. MainComponent
        frame.setSize(width, height); // size takes in a width and height of screen
        frame.setVisible( true ); // true, makes the screen/frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to close frame
    }
 // draws an individual pixel, takes in the parameters of a pixel defined above
    public void drawPoint(int x, int y, int r, int g, int b) {
        Pixel p = new Pixel(x, y, r, g, b); // creates a new pixel
        this.pixels.add(p); // consistently add pixels
        frame.repaint(); // repainting every time
    }
    //  To clear the entire content of the view
    public void clear() {
        this.pixels.clear();  // clears the pixels on the frame
        frame.repaint(); // repaints an empty screen
    }
    // Using java graphics to paint on the frame
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.WHITE);  // clear canvas
        graphics.fillRect(0, 0, width, height); // fills the frame (which is a rectangle) with an empty screen

        // for each pixel, draw them accordingly
        for (int p = 0; p < pixels.size(); p++) {
            Pixel pix = pixels.get(p); // each pixel
            graphics.setColor(new Color(pix.r, pix.g, pix.b)); // sets the color of each pixel
            graphics.fillOval(pix.x * size, pix.y * size, size, size); // Fills the Oval of the pixel at its current position, sets the size of pixel
        }
    }
}