package palmerjw;

public class BinaryCalculatorModel {
    public String firstOperand = "";
    public String secondOperand = "";
    public char operation;
    public boolean operationSet = false;
    public void clear(){
        firstOperand = "";
        secondOperand = "";
        operation = ' ';
        operationSet = false;
    }
    public String calculate()
    {
        if(operation == '+')
        {
            return addOperands();
        }
        else if(operation == '-') {
            return subtractOperands();
        }
        else
        {
            return "";
        }
    }

    private String subtractOperands() {
        int b1 = Integer.parseInt(firstOperand, 2);
        int b2 = Integer.parseInt(secondOperand, 2);
        int sum = b1 - b2;
        return Integer.toBinaryString(sum);
    }

    public void setFirst(String firstOp){
        firstOperand = firstOperand + firstOp;
    }
    public void setSecond(String secondOp){
        secondOperand =  secondOperand + secondOp;
        System.out.println(secondOperand);
    }
    public String getFirst(){
        return firstOperand;
    }
    public String getSecond(){
        return secondOperand;
    }
    public void setOperation(char operationDeclared ){
        operation = operationDeclared;
        operationSet = true;
    }
    private String addOperands()
    {
        String result = "";
        int s = 0;

        int i = firstOperand.length() - 1, j = secondOperand.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {
            s += ((i >= 0)? firstOperand.charAt(i) - '0': 0);
            s += ((j >= 0)? secondOperand.charAt(j) - '0': 0);

            result = (char)(s % 2 + '0') + result;

            s /= 2;

            i--; j--;
        }
        return result;
    }

}
