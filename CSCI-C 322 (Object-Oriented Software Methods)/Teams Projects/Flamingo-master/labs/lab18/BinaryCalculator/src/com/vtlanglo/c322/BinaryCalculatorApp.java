package com.vtlanglo.c322;

import javax.swing.*;

public class BinaryCalculatorApp {
    CalcController calcController;
    public BinaryCalculatorApp() {
        calcController = new CalcController();
    }
    public static void main(String[] args) {
        BinaryCalculatorApp app = new BinaryCalculatorApp();

    }
    public JPanel getButtonsFromView() {
        return calcController.view.panel;
    }
}


