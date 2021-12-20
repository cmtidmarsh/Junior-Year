import java.util.Observable;
import java.util.Observer;

public class binaryCalcController implements Observer  {
    private binaryCalcModel model;
    private binaryCalcView view;

    public binaryCalcController(binaryCalcModel model, binaryCalcView view){
        this.model = model;
        this.view = view;
        model.addObserver((Observer) view);
    }

    @Override
    public void update(Observable o, Object arg) {
        updateView(arg);
        updateModel(arg);
    }


    public void updateView(Object arg){
        if (arg != null && arg instanceof binaryCalcView) {
            binaryCalcView view = (binaryCalcView) arg;
        }
    }

    public void updateModel(Object arg){
        if (arg != null && arg instanceof binaryCalcModel) {
            binaryCalcModel model = (binaryCalcModel) arg;
        }

    }

    public static void main(String[] args) {
        binaryCalcView views = new binaryCalcView();
        binaryCalcModel model = new binaryCalcModel();
        binaryCalcController controller = new binaryCalcController(model, views);
    }
}
