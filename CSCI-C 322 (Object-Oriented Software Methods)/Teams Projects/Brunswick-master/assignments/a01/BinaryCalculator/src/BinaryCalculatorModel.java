import java.util.Observable;

public class BinaryCalculatorModel extends Observable {

    int firstOperand;
    int secondOperand;
    private char operation;
    int result;

    public void setFirstOperand(int operand){
        this.firstOperand = operand;
    }
    public int getFirstOperand(){
        return firstOperand;
    }

    public void setSecondOperand(int operand){
        this.secondOperand = operand;
    }

    public int getSecondOperand(){
        return secondOperand;
    }


    public void setOperation(char operation){
        setChanged();
        this.operation = operation;
        notifyObservers("");
    }

    public int BiToDecimal(int num){
        int decimal = 0;
        int x = 0;
        while(true){
            if(num == 0){
                break;
            } else {
                int temp = num%10;
                decimal += temp*Math.pow(2, x);
                num = num/10;
                x++;
            }
        }
        return decimal;
    }

    public int DecToBi(int num){
        int binary[] = new int[40];
        int index = 0;
        String solution = "0";
        while (num > 0){
            binary[index++] = num%2;
            num = num/2;
        }
        for(int i = index -1; i >= 0; i--){
            solution += binary[i];
        }
        return Integer.parseInt(solution);

    }

    public void setResult(int result){
        setChanged();
        if (operation == '+'){
            this.result = DecToBi(BiToDecimal(getFirstOperand()) + BiToDecimal(getSecondOperand()));
        }
        else this.result = DecToBi(BiToDecimal(getFirstOperand()) - BiToDecimal(getSecondOperand()));
        notifyObservers(this.result);
        clearChanged();
    }

    public int getResult(){
        return result;
    }


}
