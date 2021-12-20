
// IU Username: cmtidmar

import java.lang.Math.*;

public class TheRunTimes {
    public static void main(String[] args) {
        CalculateRunTimes runtimes = new CalculateRunTimes();
        runtimes.countInstructions(10);
        runtimes.countInstructions(100);
        runtimes.countInstructions(1000);
        runtimes.countInstructions(10000);

        System.out.println("Example 2:");
        System.out.println("for size n = 10: the instructioncounter = " + runtimes.countInstructions(10) + ", the (instructioncounter/2) = " + ((runtimes.countInstructions(10))/10));
        System.out.println("for size n = 100: the instructioncounter = " + runtimes.countInstructions(100) + ", the (instructioncounter/2) = " + ((runtimes.countInstructions(100))/100));
        System.out.println("for size n = 1000: the instructioncounter = " + runtimes.countInstructions(1000) + ", the (instructioncounter/2) = " + ((runtimes.countInstructions(1000))/1000));
        System.out.println("for size n = 10000: the instructioncounter = " + runtimes.countInstructions(10000) + ", the (instructioncounter/2) = " + ((runtimes.countInstructions(10000))/10000));

        System.out.println("Example 7:");
        System.out.println("for size n = 10: the instructioncounter = " + runtimes.countInstructions2(10, 10) + ", the (instructioncounter/2) = " + ((runtimes.countInstructions2(10, 10))/10));
        System.out.println("for size n = 100: the instructioncounter = " + runtimes.countInstructions2(100, 100) + ", the (instructioncounter/2) = " + ((runtimes.countInstructions2(100, 100))/100));
        System.out.println("for size n = 1000: the instructioncounter = " + runtimes.countInstructions2(1000, 1000) + ", the (instructioncounter/2) = " + ((runtimes.countInstructions2(1000, 1000))/1000));
        System.out.println("for size n = 10000: the instructioncounter = " + runtimes.countInstructions2(10000, 10000) + ", the (instructioncounter/2) = " + ((runtimes.countInstructions2(10000, 10000))/10000));
    }

    private static class CalculateRunTimes {
        public int countInstructions(int n){
            // example 2:
            int sum2 = 0;
            int instructioncounter = 1;
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= n; j++){
                    sum2++;
                    instructioncounter++;
                }
            }

            return instructioncounter;
        }


        public int countInstructions2(int n, int m){
            // example 7:
            int instructioncounter = 0;
            int[] a = new int[m];
            int[] b = new int[n];
            int c = 0;
            int[][] d = new int[m][n];

            d[0][0] = 0;

            for(int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++){
                    if (a[i] == b[j]) {
                        c = 0;
                        instructioncounter++;
                    }
                    else{
                        c=1;
                        instructioncounter++;
                    }
                    d[i][j] = (Math.min(d[i-1][j] + 1, Math.min(d[i][j-1] + 1, d[i-1][j-1]+c)));
                    instructioncounter++;
                }
            }

            return instructioncounter;

        }

    }

}