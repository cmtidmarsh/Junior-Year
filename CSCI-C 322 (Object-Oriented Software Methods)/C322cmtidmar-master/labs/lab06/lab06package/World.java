package lab06package;

/**
 * C322 Spring 2021 - Lab 06 Starter - 2021-02-25
 */

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;



public interface World {
    public void teh();
    public void draw(Graphics g);
    public void meh(MouseEvent e);
    public void keh(KeyEvent e);
    public boolean hasEnded();
    public void sayBye();
}
