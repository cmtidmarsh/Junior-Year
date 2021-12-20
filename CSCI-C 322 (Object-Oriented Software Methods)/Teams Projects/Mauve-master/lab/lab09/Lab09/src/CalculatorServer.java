import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer extends UnicastRemoteObject implements  BinaryCalculatorInt{
    //Model class for the binaryCalculator app
    public String operation = "";
    public int firstOperand = 0;
    public int secondOperand = 0;
    public int result = 0;

    public CalculatorServer() throws RemoteException {
        super();
    }

    public void clear(){
        this.operation = "";
        this.firstOperand = 0;
        this.secondOperand = 0;
        this.result = 0;
    }

    public void setFirstOperand(int firstOperand) throws RemoteException{
        this.firstOperand = firstOperand;
    }

    public void setOperation(String operation) throws RemoteException{
        this.operation = operation;
    }

    public void setSecondOperand(int secondOperand) throws RemoteException{
        this.secondOperand = secondOperand;
    }

    public void performOperation(int firstOperand, int secondOperand, String operation) throws RemoteException{
        switch(operation){
            case "+":
                result = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(String.valueOf(firstOperand), 2) +
                        Integer.parseInt(String.valueOf(secondOperand), 2)));
                break;

            case "-":
                if(secondOperand > firstOperand){
                    int temp = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(String.valueOf(secondOperand), 2) -
                            Integer.parseInt(String.valueOf(firstOperand), 2)));
                    result = -temp;
                }else {
                    result = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(String.valueOf(firstOperand), 2) -
                            Integer.parseInt(String.valueOf(secondOperand), 2)));
                }
                break;
            default: System.out.println("Unrecognized operation!"); break;
        }
        firstOperand = result;
        secondOperand = 0;
    }



    public static void main(String[] args) {
        // We need to set a security manager since this is a server.
        // This will allow us to customize access priviledges to
        // remote clients.
        System.setSecurityManager(new SecurityManager());

        try {
            // Create a WeatherServer object and announce its service to the
            // registry.
            CalculatorServer calculator = new CalculatorServer();
            Naming.rebind("Calculator", calculator);
            System.out.println("Calculator is ready.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}