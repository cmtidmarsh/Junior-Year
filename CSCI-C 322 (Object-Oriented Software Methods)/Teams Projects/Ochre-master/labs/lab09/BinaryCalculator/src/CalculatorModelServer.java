import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;

public class CalculatorModelServer extends UnicastRemoteObject implements CalculatorModelInterface {

    int firstOperand;
    int secondOperand;
    private char operation;
    int result;

    public CalculatorModelServer() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager());

        try {
            CalculatorModelServer calculatorModelServer = new CalculatorModelServer();
            Naming.rebind("/CalculatorModelServer", calculatorModelServer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setFirstOperand(int operand) throws RemoteException {
        this.firstOperand = operand;
    }
    public int getFirstOperand() throws RemoteException {
        return firstOperand;
    }

    public void setSecondOperand(int operand) throws RemoteException {
        this.secondOperand = operand;
    }

    public int getSecondOperand() throws RemoteException {
        return secondOperand;
    }


    public void setOperation(char operation) throws RemoteException {
        this.operation = operation;
    }

    public int biToDecimal(int num){
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

    public int decToBi(int num){
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

    public void setResult(int result) throws RemoteException {

        if (operation == '+'){
            this.result = decToBi(biToDecimal(getFirstOperand()) + biToDecimal(getSecondOperand()));
        }
        else this.result = decToBi(biToDecimal(getFirstOperand()) - biToDecimal(getSecondOperand()));
    }

    public int getResult() throws RemoteException {
        return result;
    }


}
