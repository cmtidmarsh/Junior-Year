import java.util.Observable;

public class binaryCalcModel extends Observable {

    String firstOperand;
    String secondOperand;
    String solution;
    boolean operation;

    // changed from void to return a String, since the display will need to display the firstoperand chosen
    String setFirst(int first) {
        firstOperand = String.valueOf(first);
        return firstOperand;
    }

    String setSecond(int second) {
        secondOperand = String.valueOf(second);
        return secondOperand;
    }

    void setOperation(String op) {
        switch (op) {
            case "+":
            case "-":
                operation = true;
                break;
        }
        if ("+".equals("+")) {
            int a = Integer.parseInt(firstOperand);
            int b = Integer.parseInt(secondOperand);
            int addition = a + b;
            solution = String.valueOf(addition);
        } else if ("-".equals("-")) {
            int a = Integer.parseInt(firstOperand);
            int b = Integer.parseInt(secondOperand);
            int subtraction = a - b;
            solution = String.valueOf(subtraction);
        }

    }

    // Change from void to return a String of the result because HW01 team listed as their solution as a string
    String equals() {
        return solution;
    }

    void clearAll() {
        firstOperand = "";
        secondOperand = "";
        solution = "";
        operation = false;
    }

    void notifyObserver() {

    }
}