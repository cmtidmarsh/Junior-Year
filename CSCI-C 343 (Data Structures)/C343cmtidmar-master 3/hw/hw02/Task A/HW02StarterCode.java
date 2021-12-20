
// C343 / Summer 2020
// Homework - 02
// July 8, 2020 22:52
// Clare Tidmarsh, cmtidmar


/**
 *    C343/Summer 2020 - Mitja Hmeljak - 2020-07-05
 */


// explicit import of every Java class we use from the AWT package:
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;


// explicit import of every Java class we use from the Swing package:
import javax.swing.JComponent;
import javax.swing.JFrame;
// e.g. we use https://docs.oracle.com/javase/8/docs/api/javax/swing/Timer.html
// and we DON'T use any other Java classes named Timer; e.g. we don't use:
//     https://docs.oracle.com/javase/8/docs/api/java/util/Timer.html
// It is sometimes confusing to consider all the many Java "packages", ey?)
import javax.swing.Timer;



// this HW02starterCode Java class will:
//   extend JComponent to draw into a Graphics object, and
//   implement ActionListener to periodically repaint the Graphics object.
class HW02starterCode extends JComponent implements ActionListener {

    static final int H_SIZE = 256;
    static final int V_SIZE = 512;


    // TODO: draw the content of this 2D array of integers,
    //       where each integer value in the array should be represented thus:
    //       from MIN_VALUE to 0 (included) - black color
    //       from 1 to 254 - gray color at given intensity
    //       from 255 to MAX_VALUE - white color
    Int2DArrayADT pixels = new Int2DArrayADT(V_SIZE, H_SIZE);
    javax.swing.Timer timer;





    // we have to implement actionPerformed() since we implement the ActionListener interface:
    public void actionPerformed(ActionEvent e) {
        System.out.println("here be actionPerformed() for HW02starterCode");

        // ...do whatever you need to do at repeated intervals...

        // tell the JComponent that it ought to repaint itself:
        this.repaint();
    } // end of actionPerformed()

    public Color Color(int r, int g, int b) {
        return new Color(r, g, b);
    }


    // we override the JComponent's paintComponent() method, to do some drawing:
    //  and we receive the currently active graphics for our JComponent:
    public void paintComponent(Graphics pGraphics) {
        System.out.println("here be paintComponent() for HW02starterCode");
        //
        // "The Graphics class is the abstract base class for all graphics contexts
        //   that allow an application to draw onto components that are realized on\
        //   various devices, as well as onto off-screen images."
        // https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html
        super.paintComponent(pGraphics);

        // clear background at every re-painting:
        pGraphics.setColor(Color.PINK);
        Shape lClipArea = pGraphics.getClip();
        int lWidth = lClipArea.getBounds().width;
        int lHeight = lClipArea.getBounds().height;
        pGraphics.fillRect(0, 0, lWidth, lHeight);

        // set paint color for drawing, using the constructor with RGB int values:
        // https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html#Color(int,%20int,%20int)
        Color lForegroundColor = new Color(0, 0, 0);
        pGraphics.setColor(lForegroundColor);


        // just for testing purposes,
        // let's draw a diagonal line across the Graphics context:
//        int x, y;
//        for (x=10; x<(H_SIZE -10); x++) {
//            y = x;
//            lForegroundColor = new Color((x % 256), (x % 256), (x % 256));
//            pGraphics.setColor(lForegroundColor);
//            pGraphics.drawOval(x, y, 1, 1);
        Color grey = new Color(128, 128, 128); // For from 1 to 254
        Color white = new Color(255, 255, 255); // from 255 to MAX_VALUE
        Random random = new Random();
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < pixels.n_rows; i++)
            for (int j = 0; j < pixels.n_cols; j++) {
                pixels.set(i, j, random.nextInt());
                if (pixels.get(i, j) >= min && pixels.get(i, j) <= 0) {
                    pGraphics.setColor(lForegroundColor);

                }
                if (pixels.get(i, j) >= 1 && pixels.get(i, j) <= 254) {
                    pGraphics.setColor(grey);
                }
                if (pixels.get(i, j) >= 255 && pixels.get(i, j) <= max) {
                    pGraphics.setColor(white);
                }
                pGraphics.drawOval(i, j, 1, 1);


            }
    } // end of paintComponent()



    // client code - main() method:
    public static void main(String[] args) {

        Int2DArrayADT array = new Int2DArrayADT(200, 200);
        Random random = new Random();
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < array.n_rows; i++)
            for (int j = 0; j < array.n_cols; j++) {
                array.set(i, j, random.nextInt());
            }

        // instantiate the main JComponent, i.e. "this" Java class:
        HW02starterCode theMainJComponent = new HW02starterCode();

        // create JFrame where we (the main object in its JComponent identity) can paint:
        JFrame aJFrame = new JFrame();
        aJFrame.add(theMainJComponent);
        aJFrame.setSize(H_SIZE, V_SIZE);
        aJFrame.setVisible( true );

        // start a Timer object, to periodically re-paint the JComponent:
        theMainJComponent.timer = new Timer(100, theMainJComponent);
        theMainJComponent.timer.start();
    } // end of main()


} // end of class HW02starterCode()
