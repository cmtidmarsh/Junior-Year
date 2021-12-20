package lab06package;

/**
 * C322 Spring 2021 - Lab 06 Starter - 2021-02-25
 */

import java.awt.*;

public class Circle {
    int x, y, r; // center coordinates, and radius
    public Circle(int x, int y, int r) {
        System.out.println("here be Circle()");
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public void draw(Graphics g) {
        System.out.println("here be draw() for Circle");
        g.drawOval(this.x - this.r, this.y - this.r, 2 * this.r, 2 * this.r);
    }

    void expandCircles(){ // added method to expand circle
        this.r += 1;
    }

}
