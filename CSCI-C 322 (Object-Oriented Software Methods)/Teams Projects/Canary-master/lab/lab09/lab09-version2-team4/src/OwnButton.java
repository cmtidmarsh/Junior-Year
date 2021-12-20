import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class OwnButton extends JButton {

    public OwnButton(MouseListener mouseListener, String label, int x, int y) {

        this.setBounds(x, y, 70, 70);
        this.addMouseListener(mouseListener);
        this.setLabel(label);
        this.setFont(new Font("Comic Sans", Font.PLAIN, 30));
    }
}