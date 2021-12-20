package Team13.BinaryCalc.Model;

import java.lang.Math;

public class Model {
    private int firstOperand;
    private int secondOperand;

    private Operation operation;

    public void setFirstOperand(String operand) throws NumberFormatException{
        this.firstOperand = this.convertToInteger(operand);
    }

    public void setSecondOperand(String operand) throws NumberFormatException{
        this.secondOperand = this.convertToInteger(operand);
    }

    public void setOperation(Operation opp){
        this.operation = opp;
    }

    public boolean hasOperation(){
        return this.operation != null;
    }

    private String convertToBinary(int num){
        String sign = "";
        if (num < 0) {
           num *= -1;
           sign = "-";
        }
        return sign + Integer.toBinaryString(num);
    }

    private int convertToInteger(String bin) throws NumberFormatException {
        int sign = 1;
        if (bin.charAt(0) == '-') {
           sign = -1;
           bin = bin.substring(1);
        }

        return sign * Integer.parseInt(bin, 2);
    }

    public String getResult(){
        if(this.operation != null){
            int result = this.operation.performOperation(this.firstOperand, this.secondOperand);
            return convertToBinary(result);
        }
        return null;
    }

    public void clear(){
        this.firstOperand = 0;
        this.secondOperand = 0;
        this.operation = null;
    }

    public String debug(){
        return String.valueOf(this.firstOperand) + ", " + String.valueOf(this.secondOperand) + ", " + String.valueOf(this.operation) + ", " + this.getResult();
    }
}
