import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class BinaryCalculatorView extends Observable {
    public BinaryCalculatorView.UIViewWindow viewWindow = new BinaryCalculatorView.UIViewWindow();
    public BinaryCalculatorView.CalculatorDisplayLabel lbl = new CalculatorDisplayLabel();
    boolean send = false;

    MinusButton mB = new MinusButton();
    ACButton aC = new ACButton();
    AddButton aD = new AddButton();
    EqualsButton eB = new EqualsButton();
    OneButton oB = new OneButton();
    ZeroButton zB = new ZeroButton();
    public class UIViewWindow extends JFrame implements ActionListener {
        /*
        public UIElement views[];
        Java Swing has JButtons and JLabels so we can't just have an array of UIElements
        We will have to have an array of JButtons and one JLabel
        */
        public JFrame aJFrame = new JFrame();
        public JPanel panel = new JPanel();

        public int width;
        public int height;
        public String operator = "";
        public String operand = "";

        public void draw(){

            mB.draw();
            aC.draw();
            aD.draw();
            eB.draw();
            oB.draw();
            zB.draw();
            CalculatorDisplayLabel dL = new CalculatorDisplayLabel();
            dL.draw();
        }
        public void clickAtPoint(int x, int y) {

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    /*
    public class UIElement{

    }
    */



    public interface Button{
        public void draw();
        public void clickAtPoint();
    }

    public class MinusButton extends Observable{
        public int x = 500;
        public int y = 400;
        public int width = 50;
        public int height = 50;
        JButton minusButton = new JButton("-");
        //UIViewWindow window;

        public void draw(){
            minusButton.setBounds(x, y, width, height);
            viewWindow.panel.add(minusButton);
            minusButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clickAtPoint(x,y);
                }
            } );
        }
        public void clickAtPoint(int x, int y){
            viewWindow.operator = "-";
            lbl.setTextInLbl("-");
            send = true;
            setChanged();
            notifyObservers();
            clearChanged();
        }

    }
    public class ACButton extends Observable{
        public int x = 10;
        public int y = 10;
        public int width = 50;
        public int height = 50;
        JButton acButton = new JButton("AC");
        //UIViewWindow window;

        public void draw(){
            acButton.setBounds(x, y, width, height);
            viewWindow.panel.add(acButton);
            acButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clickAtPoint(x,y);
                }
            } );
        }
        public void clickAtPoint(int x, int y){
            viewWindow.operator = "AC";
            viewWindow.operand = "";
            System.out.println("lbl.text before assignment " + lbl.text);
            lbl.text = "";
            System.out.println("lbl.text after assignment" + lbl.text);

            System.out.println("lbl.setTextInLbl(\"\") " + lbl.displayLabel.getText());
            lbl.setTextInLbl("");
            lbl.displayLabel.setText("");
            System.out.println("lbl.setTextInLbl(\"\") " + lbl.displayLabel.getText());
            viewWindow.panel.remove(6);
            viewWindow.panel.add(lbl.displayLabel);
            //lbl.displayLabel = new JLabel("0");
            send = true;
            setChanged();
            notifyObservers();
            clearChanged();
        }

    }
    public class AddButton extends Observable{
        public int x = 500;
        public int y = 460;
        public int width = 50;
        public int height = 50;
        JButton addButton = new JButton("+");
        //UIViewWindow window;

        public void draw(){
            addButton.setBounds(x, y, width, height);
            viewWindow.panel.add(addButton);
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clickAtPoint(x,y);
                }
            } );
        }
        public void clickAtPoint(int x, int y){
            //System.out.println("Hello");
            viewWindow.operator = "+";
            lbl.setTextInLbl("+");
            send = true;
            setChanged();
            notifyObservers();
            clearChanged();
            viewWindow.operand = "";
        }
    }
    public class EqualsButton extends Observable{
        public int x = 500;
        public int y = 510;
        public int width = 50;
        public int height = 100;
        JButton equalsButton = new JButton("=");
        //UIViewWindow window;

        public void draw(){
            equalsButton.setBounds(x, y, width, height);
            viewWindow.panel.add(equalsButton);
            equalsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clickAtPoint(x,y);
                }
            } );
        }
        public void clickAtPoint(int x, int y){
            System.out.println("Before assigning" + viewWindow.operator);
            viewWindow.operator = "=";
            System.out.println("After assigning" + viewWindow.operator);
            lbl.setTextInLbl("=");
            send = true;
            setChanged();
            notifyObservers();
            clearChanged();
        }

    }
    public class OneButton extends Observable{
        public int x = 10;
        public int y = 750;
        public int width = 50;
        public int height = 50;
        JButton oneButton = new JButton("1");
        //UIViewWindow window;

        public void draw(){
            oneButton.setBounds(x, y, width, height);
            viewWindow.panel.add(oneButton);
            oneButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clickAtPoint(x,y);
                }
            } );
        }
        public void clickAtPoint(int x, int y){
            viewWindow.operand += "1";
            lbl.setTextInLbl("1");
            setChanged();
            notifyObservers();
            clearChanged();
        }

    }
    public class ZeroButton extends Observable{
        public int x = 10;
        public int y = 810;
        public int width = 100;
        public int height = 50;
        JButton zeroButton = new JButton("0");
        //UIViewWindow window;

        public void draw(){
            zeroButton.setBounds(x, y, width, height);
            viewWindow.panel.add(zeroButton);
            zeroButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clickAtPoint(x,y);
                }
            } );
        }
        public void clickAtPoint(int x, int y){
            viewWindow.operand += "0";
            lbl.setTextInLbl("0");
            setChanged();
            notifyObservers();
            clearChanged();
        }
    }
    //This is our JLabel soooo
    public class CalculatorDisplayLabel{
        public String text = "";
        public int x = 0;
        public int y = 400;
        public int width = 600;
        public int height = 200;
        JLabel displayLabel = new JLabel("0");

        public void setTextInLbl(String t){
            text += t;
            //System.out.println(text);
            //lbl.displayLabel.setText(text);
            displayLabel = new JLabel(text);
            viewWindow.panel.remove(6);
            viewWindow.panel.add(displayLabel);

            /*
            if (viewWindow.operator == "AC"){
                lbl.displayLabel.setText("");
                text = "";
            }
             */
            //viewWindow.draw();
        }
        public void draw(){
            displayLabel.setBounds(x, y, width, height);
            viewWindow.panel.add(displayLabel);
        }
    }
}
