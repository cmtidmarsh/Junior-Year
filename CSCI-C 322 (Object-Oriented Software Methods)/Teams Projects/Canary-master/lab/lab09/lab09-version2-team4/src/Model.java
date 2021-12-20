import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Model extends UnicastRemoteObject implements CalculatorInterface {

    private int result = 0;
    private String answer = "";

    public Model() throws RemoteException {
        super();
    }

    @Override
    public String performOperation(String n1, String n2, String o) throws RemoteException {
        ArrayList<Integer> arr = new ArrayList<>();
        if (o.equals("+")) {
            result = decimalToBinary(arr, this.binaryToDecimal(n1) + this.binaryToDecimal(n2));
            answer = String.valueOf(result);

        } else if (o.equals("-")) {
            result = this.binaryToDecimal(n1) - this.binaryToDecimal(n2);
            result = decimalToBinary(arr, this.binaryToDecimal(n1) - this.binaryToDecimal(n2));
            answer = String.valueOf(result);
        } else {
            answer = "operation is incorrect";
        }
        return answer;
    }

    @Override
    public int binaryToDecimal(String n1) throws RemoteException{
        int n;
        n = Integer.parseInt(n1, 2);
        return n;
    }

    @Override
    public int decimalToBinary(ArrayList<Integer> arr, int n) throws RemoteException{
        int count = 0;
        int size = 0;
        int n1 = 0;
        int n2 = 0;
        if (n < 0) {
            n2 = n;
            n = n * -1;
        }
        n1 = n;
        for (int i = 0; n1 > 0; i++) {
            if (n1 / 2 != 0) {
                size++;
                n1 = n1 / 2;
                arr.add(0);
            } else if (n1 == 1) {
                arr.add(0);
                n1 = 0;
            }
        }
//        System.out.println("size:  " + size);
        while (n > 0) {
            arr.set(count, (int) ((n % 2) * Math.pow(10, count)));
            n = n / 2;
            n1 += arr.get(count);
            count++;
            if (n == 0) {
                break;
            }
        }
        if (n2 < 0) {
            n1 = n1 * -1;
        }
        return n1;
    }

    public static void main(String[] args) {

        System.setSecurityManager(new SecurityManager());

        try{
            Model m = new Model();
            Naming.rebind("/BinaryCal",m);
            System.out.println("Calculator is ready to go");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}