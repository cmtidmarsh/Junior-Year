import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.Naming;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Observable;

public class View extends Observable {

    private Controller controller;

    private String answer   = "";
    private String inputNum = "";

    public boolean complete = false;

    private JFrame jFrame  = new JFrame();
    private JLabel jLabel  = new JLabel();
    private String textStr = "";
    private MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) { }
        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getSource() == numButton1){
                textStr += "1";
                complete = false;
            }else if(e.getSource() == numButton0){
                textStr += "0";
                complete = false;
            }else if(e.getSource() == clearButton) {
                complete = false;
                controller.setO("");
                controller.setLastO("+");
                ArrayList<String> newArray = new ArrayList<>();
                newArray.add("0");
                newArray.add("0");
                controller.setNumStrArrayList(newArray);
                textStr = "";
            }else if(e.getSource() == plusButton) {
                complete = true;
                if(textStr.equals("")){
                    textStr = "0";
                }
                inputNum = textStr;
                textStr = "";
                controller.setO("+");
            }else if(e.getSource() == subButton) {
                complete = true;
                if(textStr.equals("")){
                    textStr = "0";
                }
                inputNum = textStr;
                textStr = "";
                controller.setO("-");
            }else if(e.getSource() == equalButton) {
                complete = true;
                if(textStr.equals("")){
                    textStr = "0";
                }
                inputNum = textStr;
                textStr  = "";
                controller.setO("=");
            }
            setChanged();
            notifyObservers(); // update textStr
            if(e.getSource() == equalButton) {
                textStr = answer;
            }
            updateText();
        }
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    };

    private OwnButton numButton1 = new OwnButton(mouseListener, "1",  10, 140);
    private OwnButton numButton0 = new OwnButton(mouseListener, "0", 140, 140);

    private OwnButton subButton   = new OwnButton(mouseListener, "-", 140,  70);
    private OwnButton plusButton  = new OwnButton(mouseListener, "+", 265,  70);
    private OwnButton equalButton = new OwnButton(mouseListener, "=", 265, 140);
    private OwnButton clearButton = new OwnButton(mouseListener, "C",  10,  70);

    public View(int x, int y, int width, int height, Controller controller){

        this.controller = controller;

        this.addObserver(controller);
        jFrame.setVisible(true);
        jFrame.setTitle("Binary Calculator");
        jFrame.setBounds(x, y, width, height);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLayout(null);
        jFrame.getContentPane().setBackground(Color.black);
        jFrame.add(numButton0);
        jFrame.add(numButton1);
        jFrame.add(clearButton);
        jFrame.add(subButton);
        jFrame.add(plusButton);
        jFrame.add(equalButton);

        jLabel.setText(textStr);
        jLabel.setFont(new Font("Comic Sans", Font.PLAIN, 36));
        jLabel.setVisible(true);
        jLabel.setBounds(11,0,322,70);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setForeground(Color.WHITE);
        jFrame.add(jLabel);
    }

    public void updateText(){ jLabel.setText(textStr); }
    public String getInputNum() {
        return inputNum;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }

}