// C343 / Summer 2020
// Lab Mini Assignment - 04
// July 1, 2020 9:27
// Clare Tidmarsh, cmtidmar



// interface
import java.util.Arrays;

interface Int2DArrayInterface{
    void set(int row, int col, int value);
    int get(int row, int col);
    void zeroArray();
    void setRow(int row, int value);
    int[] getRow(int row);
    void setCol(int col, int value);
    int[] getCol(int col);


}


public class Int2DArrayADT implements Int2DArrayInterface {

    private int[][] array;
    private int n_rows;
    private int n_cols;

    public static void main(String[] args) {
        Int2DArrayADT array1 = new Int2DArrayADT(3, 3);
        // testing set and get functions
        array1.set(0, 0, 6);
        array1.set(1, 1, 7);
        array1.set(2, 2, 9);
        System.out.println(array1.get(0, 0));
        System.out.println(array1.get(1, 1));
        System.out.println(array1.get(2, 2));

        // testing at random points chosen on the array using zeroArray()
        array1.zeroArray();
        System.out.println(array1.get(2, 1));
        System.out.println(array1.get(0, 2));
        System.out.println(array1.get(1, 2));

        // testing to set rows to a value
        array1.setRow(2, 13);
        array1.setRow(0, 15);
        array1.setRow(1, 18);
        System.out.println(Arrays.toString(array1.getRow(2)));
        System.out.println(Arrays.toString(array1.getRow(0)));
        System.out.println(Arrays.toString(array1.getRow(1)));

        // testing to set and get columns to a value
        array1.setCol(0, 3);
        array1.setCol(1, 9);
        array1.setCol(2, 5);
        System.out.println(Arrays.toString(array1.getCol(0)));
        System.out.println(Arrays.toString(array1.getCol(1)));
        System.out.println(Arrays.toString(array1.getCol(2)));






    }
    // constructor
    Int2DArrayADT(int n_rows, int n_cols) {
        array = new int[n_rows][n_cols];
        this.n_rows = n_rows;
        this.n_cols = n_cols;

    }

    // setting individual values to the array
    @Override
    public void set(int row, int col, int value) {
        array[row][col] = value;
    }
    // retrieving individual values to the array
    @Override
    public int get(int row, int col) {
        return array[row][col];

    }
    // Resetting all values in the 2d array to zero
    @Override
    public void zeroArray() {
        for (int i = 0; i < n_rows; i++)
            for (int j = 0; j < n_cols; j++) {
                array[i][j] = 0;
            }
    }
    // setting row values to the array
    @Override
    public void setRow(int row, int value) {
        for (int i = 0; i < n_cols; i++){
            array[row][i] = value;
        }
    }
    // retrieving row values to the array
    @Override
    public int[] getRow(int row) { //
            int[] rowValues = array[row];
            return rowValues;
    }
    // // setting column values to the array
    @Override
    public void setCol(int col, int value) {
        for (int i = 0; i < n_rows; i++){
            array[i][col] = value; }
    }
    // retrieving column values to the array
    @Override
    public int[] getCol(int col) {
        int[] arrayCol = new int[n_rows];
        for (int i = 0; i < arrayCol.length; i++) {
            arrayCol[i] = array[i][col];
        }
        return arrayCol;
    }
}

