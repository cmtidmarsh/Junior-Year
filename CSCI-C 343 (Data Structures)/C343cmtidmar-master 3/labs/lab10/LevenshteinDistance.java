//       C343 / Summer 2020
//        Lab - 10
//        July 15, 15:17
//        Clare Tidmarsh, cmtidmar


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LevenshteinDistance {

    public static int min(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        }
        if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }

    public static int editDistance(String s1, String s2) {
        long lTimeBefore = System.nanoTime();
        int m = s1.length();
        int n = s2.length();
        int c = 0;

        int d[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            d[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) { //if (a[i] == b[i])
                    c = 0;
                } else {
                    c = 1;
                }

                d[i][j] = min(d[i - 1][j] + 1, // a
                        d[i][j - 1] + 1, // b
                        d[i - 1][j - 1] + c); // c
            }
        }
        long lTimeAfter = System.nanoTime();
        long lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
        System.out.println(lElapsedNanoSeconds);
        return d[m][n];
    }

    public static int hammingDistance(String s1, String s2) {
        long lTimeBefore = System.nanoTime();
        int counter = 0;
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s1.charAt(i))
                    counter++;
            }
        } else {
            editDistance(s1, s2);
        }
        long lTimeAfter = System.nanoTime();
        long lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
        System.out.println(lElapsedNanoSeconds);
        return counter; // returns distance
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/cmeichuan/Documents/Flatland(withASCIIillustrations)_section.txt");
        File file2 = new File("/Users/cmeichuan/Documents/Flatland_section.txt");
        Scanner scanFile = new Scanner(file);
        Scanner scanFile2 = new Scanner(file2);

        // Levenshtein Distance
        int counter = 0;
        while (scanFile.hasNextLine() || scanFile2.hasNextLine()) {
            int x = editDistance(scanFile.nextLine(), scanFile2.nextLine());
            counter++;
                System.out.println("The Levenshtein Distance for line " + counter + " is " + x);
        }

        // Hamming Distance
        int counter2 = 0;
        while (scanFile.hasNextLine() || scanFile2.hasNextLine()) {
            int y = hammingDistance(scanFile.nextLine(), scanFile2.nextLine());
            counter2++;
            System.out.println("The Hamming Distance for line " + counter2 + " is " + y);

        }
    }

}

