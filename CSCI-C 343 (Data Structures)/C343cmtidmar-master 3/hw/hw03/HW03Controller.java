//  C343 / Summer 2020
// Homework - 03
// July 13, 22:50
// Clare Tidmarsh, cmtidmar

import java.util.Observable;
import java.util.Observer;

public class HW03Controller implements Observer {

    public void update(Observable o, Object arg) {
        if (arg != null && arg instanceof HW03Model) {
            HW03Model model = (HW03Model) arg;
            int[][] c = model.getArray();
            for (int i = 0; i < model.width; i++){
                for (int j =0; j < model.height; j++){
                   // model.drawPoint(i, j, c);
                    }
            }
        }
    }


    public static void main(String[] args) {
        //testing if sorting HW03Model methods work
        HW03Model array = new HW03Model(2, 2);
        System.out.println("Random values: ");
        array.randomize();
        System.out.println("SortArray1: ");
        array.sortArray1();
        System.out.println("SortArray2: ");
        array.sortArray2();
    }
}

