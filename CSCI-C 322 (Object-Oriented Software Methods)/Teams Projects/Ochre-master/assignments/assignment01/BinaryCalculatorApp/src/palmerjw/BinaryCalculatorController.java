package palmerjw;

import java.awt.*;

public class BinaryCalculatorController {

    BinaryCalculatorModel model;
    BinaryCalculatorView view;
    String displayText;


    public BinaryCalculatorController() {
        this.model = new BinaryCalculatorModel();
        this.view = new BinaryCalculatorView(this);
        this.displayText = "";
    }
    public void setView(BinaryCalculatorView view)
    {
        this.view = view;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BinaryCalculatorView window = new BinaryCalculatorView(new BinaryCalculatorController());
                    window.getController().setView(window);
                    window.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

    }

    public void onOperationPress(String e)
    {
        char[] array =e.toCharArray();
        // set operation in model and view
        this.model.setOperation(array[0]);
        this.displayText += e;
        this.view.setScreenText(this.displayText);
    }

    public void onDigitPress(String e)
    {

        // when operationSet is false, set the first var, otherwise set the second
        if(!this.model.operationSet) {
            this.model.setFirst(e);
        } else {
            this.model.setSecond(e);
        }

        // update screen
        this.displayText += e;
        this.view.setScreenText(this.displayText);
    }

    public void onClearPress() {

        // clear screen and update text
        this.model.clear();
        this.displayText = "";
        this.view.setScreenText(this.displayText);

    }

    public void onEqualPress() {

        this.displayText = this.model.calculate();
        this.view.setScreenText(this.displayText);

    }



}
