// C343 / SUMMER 2020
// HOMEWORK - 04
//JULY 19, 2020 20:36
// Clare Tidmarsh, cmtidmar

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.util.Observable;

public class HW04Model extends Observable {
    private String a = null;
    private String b = null;
    private int[][] d;
    private char[][] e;

     // The location of the first string (i.e., string a)
    public static final String A_FILE = "/Users/cmeichuan/Documents/Flatland(withASCIIillustrations)_section.txt";

     // The location of the second string (i.e., string b)
    public static final String B_FILE = "/Users/cmeichuan/Documents/Flatland_section.txt";

    // Create a new Model
    // The strings will be read in, and the width/height will be compared to ensure the user
    // has enough space to show the comparison
    public HW04Model(int width, int height) {
        try (
                BufferedReader aReader = new BufferedReader(new FileReader(A_FILE)); // reads the contents of the first file
                BufferedReader bReader = new BufferedReader(new FileReader(B_FILE)) // reads the contents of the second file
        ) {
            String tmp = aReader.readLine(); // reads the lines in file a
            while (tmp != null) { // if there are contents in the file
                a += tmp.replace("\n", ""); // delete the <new line> thing
                tmp = aReader.readLine(); // reread the "new" lines
            }
            tmp = bReader.readLine(); // reads the lines in file a
            while (tmp != null) { // if there are contents in the file
                b += tmp.replace("\n", ""); // delete the <new line> thing
                tmp = bReader.readLine(); // reread the "new" lines
            }
        } catch (IOException e) {//if there's an exception
            System.out.println("Unable to open file(s)"); // print
            //System.exit(1);
//            a = "auto";
//            b = "auot";
        }
        if (width <= a.length() || height <= b.length()) {
            System.out.printf("WARNING: Strings are longer than viewport; recommend minimum of (%d, %d)\n", a.length() + 1, b.length() + 1);
        }
    }


    // Gets a single line of the d array, returns That specific column (well, row) for the distance
    public int[] dLine(int index) {
        return d[index];
    }

    // Get a single line of the e array, returns That specific column (well, row) for the distance
    public char[] eLine(int index) {
        return e[index];
    }

    // gets the a string, returns the string
    public String aString() {
        return this.a;
    }

    // gets the b string, returns the string
    public String bString() {
        return this.b;
    }

    // Calculate the levenshtein distance between the two strings (presumably, a and b), s1 is the first string and s2 is the second string
    // returns The minimum Levenshtein distance
    public int dist(String s1, String s2){
        int m = s1.length(); // length of the first string
        int n = s2.length(); // length of the second string
        int c = 0; // value in pseudocode

        d = new int[m + 1][n + 1]; // d array
        e = new char[m + 1][n + 1]; // e array
        for (int i = 0; i <= m; i++) { // for each character in the string a
            d[i][0] = i; // sort
        }
        for (int j = 0; j <= n; j++) { // // for each character in the string b
            d[0][j] = j; // sort
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) { // if the characters in both strings are the same at the same position then
                    c = 0; // set c to be 0
                } else { // if not equal
                    c = 1; // set c to be 1
                }
                int insertion = d[i - 1][j] + 1; // levenshtein insertion
                int deletion = d[i][j - 1] + 1; //levenshtein delete
                int substitution = d[i - 1][j - 1] + c; // levenshtein sub

                d[i][j] = min(insertion, deletion, substitution); // find the min in the 3 parameters
                // if the two compared characters are the same, store e[i][j] = ' '
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    e[i][j] = ' ';
                    // if a character is inserted, then store e[i][j] = 'I'
                } else if (d[i][j] == insertion) {
                    e[i][j] = 'I';
                    // if the character is deleted, then store e[i][j] = 'D'
                } else if (d[i][j] == deletion) {
                    e[i][j] = 'D';
                    // if the character is substituted, then store e[i][j] = 'S'
                } else {
                    e[i][j] = 'S';
                }

            }
            this.setChanged(); // observable updating every time program performed
            this.notifyObservers(); // notifying the observers (will be HW04Controller)
            // Uncomment to see it "in action":
            /*
            try {
                Thread.sleep(10000);
            } catch (Exception e) { }
            */
        }
        return d[m][n];
    }


    // Helper function: Calculates the minimum of the three operations
    // takes in int a - The first operation
    //          int b - The second operation
    //          int c - The third operation
    //returns the minimum cost (i.e., for Levenshtein)
    public static int min(int a, int b, int c) {
        // If a is the smallest, get out
        if (a <= b && a <= c) {
            return a;
        }
        // if b is the smallest, get out
        if (b <= a && b <= c) {
            return b;
        }
        // get out
        return c;
    }

    // "Helper" function: Convenience method for finding min of array
    // takes in  int[] d The array
    public int min(int[] d) {
        int minimum = d[0];
        int minInd = 0;
        for (int j = 0; j < d.length; j++) {
            if (d[j] < minimum) {
                minimum = d[j];
                minInd = j;
            }
        }
        return minInd; // returns the minimum value
    }
    /**
     * @note this assumes you have at least one element!
     */
}