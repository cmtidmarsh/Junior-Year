package com;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Graphics2D;



public class FlippingPixels extends JFrame {
    public FlippingPixels(){
        setTitle("Flipping Pixels");
        setSize(550, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        // "E" complete
        g.drawOval(250, 100, 150, 00);
        g.drawOval(250, 175, 75, 00);
        g.drawOval(250, 239, 150, 00);
        g.drawOval(250, 100, 0, 139);

        //"I" complete
        g.drawOval(475, 95, 0, 150);

        //"A" complete
        g.drawOval(73, 150, 86, 0);

        g2.rotate(30.0 * Math.PI / 180.0,13,12);
        g.drawOval(133, 15, 0, 190);
        g2.rotate(-60 * Math.PI / 180, 200, 40);
        g.drawOval(188, -30, 0, 190);





    }

    public static void main(String[] args){
        FlippingPixels f = new FlippingPixels();
        f.paint(null);
    }
}
