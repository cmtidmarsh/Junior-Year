import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    private View  view  = new  View(100,100,347,235, this);
    private Model model = new Model();
    private ArrayList<String> numStrArrayList = new ArrayList<>();
    private String lastO = "+";
    private String o = "";

    public Controller() throws RemoteException {
    }

    public void setO(String o) { this.o = o; }
    public void setLastO(String lastO) { this.lastO = lastO; }
    public void setNumStrArrayList(ArrayList<String> numStrArrayList) {
        this.numStrArrayList = numStrArrayList;
    }

    public static void main(String[] args) throws RemoteException {
        Controller controller = new Controller();
        controller.numStrArrayList.add("0");
        controller.numStrArrayList.add("0");
    }

    private void operate(String currentO) {


        if (!lastO.equals("")) {
            if (numStrArrayList.get(0).equals("0")) {
                numStrArrayList.set(0, view.getInputNum());
            } else {
                numStrArrayList.set(1, view.getInputNum());
            }
            numStrArrayList.set(0, model.performOperation(numStrArrayList.get(0), numStrArrayList.get(1), lastO));
            numStrArrayList.set(1, "0");
        }

        if (currentO.equals("=")) {
//            System.out.println(lastO);
            lastO = "";
        } else {
//            System.out.println(currentO);
            lastO = currentO;
        }

//        System.out.println(numStrArrayList.get(0));
        view.setAnswer(numStrArrayList.get(0));
    }

    @Override
    public void update(Observable o, Object arg) {
        if(view.complete){
            operate(this.o);
            this.o = "";
            System.out.println(numStrArrayList.toString());
        }
    }
}