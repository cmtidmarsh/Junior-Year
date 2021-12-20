import java.util.Observable;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class BinaryCalculatorModel extends UnicastRemoteObject { //extends observable was here
    public Total modelTotal = new Total();
    public int firstOperand = 999;
    public int secondOperand = 999;
    public String output = "";
    boolean send = false;

    public BinaryCalculatorModel() throws java.rmi.RemoteException{
        super();
    }

    public interface Operation extends java.rmi.Remote {

        public int performOperation() throws java.rmi.RemoteException;
    }

    class AdditionOperation implements Operation{
        //public int firstOperand;
        //public int secondOperand;

        public int performOperation() throws RemoteException {
            return firstOperand + secondOperand;
        }
    }

    class SubtractionOperation implements Operation{
        //public int firstOperand;
        //public int secondOperand;

        public int performOperation() {
            return firstOperand - secondOperand;
        }
    }


    public class Total extends Observable{
        //public int firstOperand = 999;
        //public int secondOperand = 999;
        public Operation operation;
        public String operator;
        public int result;

//        public Total() throws java.rmi.RemoteException { //default constructor
//            super();
//        }

        public void clear(){
            result = 0;
            firstOperand = 999;
            secondOperand = 999;
            operator = "";
            //changeStartingValue();
            output = "";

        }
        public void performOp() throws RemoteException {
            if (operator == "AC"){
                System.out.println("inside AC operator" + firstOperand);
                System.out.println("inside AC operator" + secondOperand);
                clear();
            } else if (operator == "+"){
                operation = new AdditionOperation();
                System.out.println("inside + operator" + firstOperand);
                System.out.println("inside + operator" + secondOperand);
            } else if (operator == "="){
                System.out.println("inside = operator" + firstOperand);
                System.out.println("inside = operator" + secondOperand);
                result = operation.performOperation();
                changeStartingValue();
            }else {
                operation = new SubtractionOperation();
                System.out.println("inside - operator" + firstOperand);
                System.out.println("inside - operator" + secondOperand);
            }
        }
        public void changeStartingValue(){

            output = Integer.toBinaryString(result);
            System.out.println(output);
            //send = true;
            /*
            setChanged();
            notifyObservers();
            clearChanged();

             */
        }
        public int getFirstOperand(){
            return firstOperand;
        }
        public int getSecondOperand(){
            return secondOperand;
        }
        public void setOperator(String c){
            operator = c;
        }
        public void setFirstOperand(int value){
            firstOperand = value;
        }
        public void setSecondOperand(int value){
            secondOperand = value;
        }
    }

    public static void main(String[] args) {
        // We need to set a security manager since this is a server.
        // This will allow us to customize access priviledges to
        // remote clients.
        System.setSecurityManager(new SecurityManager());

        try {
            // Create a WeatherServer object and announce its service to the
            // registry.
            BinaryCalculatorModel modelMain = new BinaryCalculatorModel();
            Naming.rebind("/BinaryCalculatorModel", modelMain);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
