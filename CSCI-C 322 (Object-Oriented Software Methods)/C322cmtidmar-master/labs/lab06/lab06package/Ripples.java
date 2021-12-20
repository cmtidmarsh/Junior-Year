package lab06package;

/**
 * C322 Spring 2021 - Lab 06 Starter - 2021-02-25
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ripples implements World {
    ArrayList<Circle> listOfCircles = new ArrayList<>();
    // consider: what state do you want to keep?
    public Ripples() {
    }

    int count = 0;
    public void teh() {
            this.count += 1; // touch event?
    }

    public void meh(MouseEvent e) {
        int x = e.getX(); // get x of Circle
        int y = e.getY(); // get y of Circle
        int r = 10; // radius of Circle
        Circle circle = new Circle(x, y, r); // create a new circle every time mouse is clicked/mouse event occurs
        listOfCircles.add(circle); // add each new circle to the "storage unit" aka the array listOfCircles


    }
    public void keh(KeyEvent e) {

    }
    public void draw(Graphics g) {
        //g.setColor(Color.RED);
        //g.fillRect(100, 100, 200 - count, 200 - count);
        // g.setColor(Color.BLACK);
        // g.drawRect(100, 100, 200 - count, 200 - count);
        for (Circle circle : listOfCircles) { // for each time mouse event happens
            teh(); // increase the touch event by 1
            circle.expandCircles(); // mathematically expand circles
            circle.draw(g); // then draw
        }
    }
    public boolean hasEnded() {
        return false;
    };
    public void sayBye() {
        System.out.println("Bye Bye Blackbird. I mean Bye Bye Ripples.");
    };
    public static void main(String[] args) {
        BigBang b = new BigBang(new Ripples());
        b.start(50, 400);
    }
}
