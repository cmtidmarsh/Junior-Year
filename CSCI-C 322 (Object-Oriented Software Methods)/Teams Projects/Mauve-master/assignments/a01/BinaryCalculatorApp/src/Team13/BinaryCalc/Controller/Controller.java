package Team13.BinaryCalc.Controller;
import Team13.BinaryCalc.Model.AddOperation;
import Team13.BinaryCalc.Model.Model;
import Team13.BinaryCalc.Model.SubtractOperation;
import Team13.BinaryCalc.View.CalculatorFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private CalculatorFrame view;

    public Controller(Model model, CalculatorFrame view){
        this.model = model;
        this.view = view;
        this.addEventListeners();
    }

    private void addEventListeners(){
        // NUMERIC BUTTONS

        this.view.buttons.btnOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digitPressed(1);
            }
        });

        this.view.buttons.btnZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                digitPressed(0);
            }
        });

        // OPERATION BUTTONS
        this.view.buttons.btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!model.hasOperation()){
                    model.setFirstOperand(view.screen.getScreenText());
                }
                model.setOperation(new AddOperation());
                view.screen.setScreenText("0");
            }
        });

        this.view.buttons.btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!model.hasOperation()){
                    model.setFirstOperand(view.screen.getScreenText());
                }
                model.setOperation(new SubtractOperation());
                view.screen.setScreenText("0");
            }
        });

        // EQ BUTTON
        this.view.buttons.btnEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setSecondOperand(view.screen.getScreenText());
                if(model.hasOperation()){
                    view.screen.setScreenText(model.getResult());
                    model.clear();
                }
            }
        });

        // AC BUTTON
        this.view.buttons.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.screen.getScreenText().equals("0")){
                    model.clear();
                }else{
                    view.screen.setScreenText("0");
                }
            }
        });
    }

    private void digitPressed(int digit){
        this.view.screen.setScreenText(this.view.screen.getScreenText() + String.valueOf(digit));
    }



}
