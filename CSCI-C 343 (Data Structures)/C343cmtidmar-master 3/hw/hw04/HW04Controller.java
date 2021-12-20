// C343 / SUMMER 2020
// HOMEWORK - 04
//JULY 19, 2020 20:36
// Clare Tidmarsh, cmtidmar

import java.util.Observable;
import java.util.Observer;


public class HW04Controller implements Observer {
    // instantiates one HW04Model object and one HW04View object
    public HW04Model model = new HW04Model(V_WIDTH, V_HEIGHT);
    public HW04View view = new HW04View(V_WIDTH, V_HEIGHT);

    private String a = null; // a string from the first txt file (w/out ASCII version)
    private String b = null; // a string from the second txt file (w/ ASCII version)
    private int aIndex = 0; // index of a

    // 13 inch MacBook Pro, googled screen dimensions: 2560 x 1600
    public static final int V_WIDTH = 2560;
    public static final int V_HEIGHT = 1600;

    public static void main(String[] args) {
        HW04Controller controller = new HW04Controller(); //creates a controller object
        controller.model.dist(controller.model.aString(), controller.model.bString()); // controller calls the dist function from the model
    }
    // constructor
    public HW04Controller() {
        model.addObserver(this); // add the model to the observer
        view.clear(); // uses the HW04View to clear the screen
    }

    /*
    draw a horizontal line for the aString(), in the upper part of your view
    draw a vertical line for the bString(), on the left side of your view
    use color to show where there's text in the two strings:

*/

    public void update(Observable obs, Object o) {
        // do something interesting
        // if a == null then this is the first time
        if (a == null) {
            // first time!
            a = model.aString();
            b = model.bString();
            // draw string a
            for (int c = 0; c < a.length(); c++) {
                char letter = a.charAt(c);
                // draw a white pixel, i.e. when there is a ' ' space character in the string
                if (letter == ' ') {
                    view.drawPoint(c + 1, 0, 255, 255, 255); // white (255,255,255)
                    // drawing a cyan pixel, i.e. when there is a vowel in the string
                } else if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                    view.drawPoint(c + 1, 0, 0, 255, 255); // cyan (0,255,255)
                    // draw a purple pixel, i.e. when there is a consonant in the string.
                } else {
                    view.drawPoint(c + 1, 0, 128, 0, 128); // purple (128,0,128)
                }
            }
            // draw string b
            for (int c = 0; c < b.length(); c++) {
                char letter = b.charAt(c); // letter = a character in the string
                // draw a white pixel, i.e. when there is a ' ' space character in the string
                if (letter == ' ') {
                    view.drawPoint(0, c + 1, 255, 255, 255); // white(255,255,255)
                    // drawing a cyan pixel, i.e. when there is a vowel in the string
                } else if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                    view.drawPoint(0, c + 1, 0, 255, 255); // cyan(0,255,255)
                    // draw a purple pixel, i.e. when there is a consonant in the string.
                } else {
                    view.drawPoint(0, c + 1, 128, 0, 128); //  purple(128,0,128)
                }
            }
        }
        char[] e = model.eLine(aIndex); // A string, or "line," from the first txt file
        int[] d = model.dLine(aIndex); // A string, or "line," from the second txt file
        // For now, assuming line == i, inner loop is j
        // iterate over each character in e, and draw it accordingly
        int x = aIndex + 1;
        for (int j = 0; j < b.length(); j++) { // for each character in the second string
            int y = j + 1;
            // draw a green pixel, i.e.   when the two compared characters are the same, store, i.e. when e[i][j] = ' '
            if (e[j] == ' ') {
                view.drawPoint(x, y, 0, 255, 0); // green (0, 255,0)
                // draw a yellow pixel, i.e.   when a character is substituted, i.e. when e[i][j] = 'S'
            } else if (e[j] == 'S') {
                view.drawPoint(x, y, 255, 255, 0); // yellow (255, 255,0)
                // draw a red pixel, i.e.   when a character is deleted, i.e. when e[i][j] = 'D'
            } else if (e[j] == 'D') {
                view.drawPoint(x, y, 255, 0, 0); // red (255,0,0)
                // draw a blue pixel, i.e.   when a character is inserted, i.e. when e[i][j] = 'I'
            } else if (e[j] == 'I') {
                view.drawPoint(x, y, 0, 0, 255); // blue (0,0,255)
            }
        }
        // Find local minimum
        int minInd = model.min(d); // using the levenshtein distance minimum helper function, find min
        view.drawPoint(x, minInd + 1, 0, 0, 0); // draw the minimum point, and color as black (0,0,0)
        aIndex++; // go through the index
    }
}
