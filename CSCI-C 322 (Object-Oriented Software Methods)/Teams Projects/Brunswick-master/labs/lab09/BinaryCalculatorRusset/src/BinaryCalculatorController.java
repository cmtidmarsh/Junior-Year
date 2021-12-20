import java.util.Observable;
import java.util.Observer;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class BinaryCalculatorController implements Observer {

    public BinaryCalculatorController() throws RemoteException {
    }

    public void update(Observable O, Object arg){
        System.out.println("Hello 1");
        /*
        if (view.send == true) {
            System.out.println("Inside first");
            sendInputToModel();
            view.send = false;
        }
        if (model.send == true) {
            System.out.println("Inside Second");
            sendOutputToView();
            model.send = false;
        }
        */
        try {
            sendInputToModel();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        sendOutputToView();
    }
    BinaryCalculatorModel model = new BinaryCalculatorModel();
    BinaryCalculatorView view = new BinaryCalculatorView();
    public int receivedInput = 0;
    public String receivedOutput = "";
    public String receivedCommand = "";

    public void sendOutputToView(){

        //model.modelTotal.performOp();
        //if (model.output != null) {
        receivedOutput = model.output;
        view.lbl.displayLabel.setText(receivedOutput);

       // }
        view.lbl.setTextInLbl(receivedOutput);


    }
    public void sendInputToModel() throws RemoteException {
        if (view.viewWindow.operand != "") {
            receivedInput = Integer.parseInt(view.viewWindow.operand, 2);
        }
        System.out.println("Received input: " + receivedInput);
        receivedCommand = view.viewWindow.operator;
        System.out.println("In controller " + receivedCommand);
        if (receivedCommand == "+" || receivedCommand == "-") {
            model.modelTotal.setFirstOperand(receivedInput);
            model.modelTotal.setOperator(receivedCommand);
            model.modelTotal.performOp();
        } else if (receivedCommand == "=") {
            model.modelTotal.setSecondOperand(receivedInput);
            model.modelTotal.setOperator(receivedCommand);
            model.modelTotal.performOp();
        } else if (receivedCommand == "AC"){
            model.modelTotal.clear();
            view.viewWindow.aJFrame.repaint();
        }
        //sendOutputToView();
    }

    public static void main(String[] args) {

        try{
            Remote robj = Naming.lookup("//localhost/BinaryCalculatorModel");
            BinaryCalculatorModel modelMain = (BinaryCalculatorModel)robj;
            BinaryCalculatorView viewMain = new BinaryCalculatorView();
            BinaryCalculatorController controller = new BinaryCalculatorController();

            controller.model = modelMain;
            controller.view = viewMain;

            while (true){ //updates server object (model) with gui input from view



                //controller.view.viewWindow.aJFrame.add(controller.view.viewWindow);
                viewMain.mB.addObserver(controller);
                viewMain.aC.addObserver(controller);
                viewMain.aD.addObserver(controller);
                viewMain.eB.addObserver(controller);
                viewMain.oB.addObserver(controller);
                viewMain.zB.addObserver(controller);
                modelMain.modelTotal.addObserver(controller);

                controller.view.viewWindow.aJFrame.setSize(600,900);

                controller.view.viewWindow.aJFrame.add(controller.view.viewWindow.panel);
                controller.view.viewWindow.draw();
                controller.view.viewWindow.aJFrame.setVisible(true);
                Thread.sleep(550);

            }

        }catch(Exception e){
            System.out.println(e.getMessage());

        }





    }
}
