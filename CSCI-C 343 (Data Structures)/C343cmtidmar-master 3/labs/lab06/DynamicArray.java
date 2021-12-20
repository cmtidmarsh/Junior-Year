//        C343 / Summer 2020
//        lab mini assignment - 06
//        July 3, 2020 22:47
//        Clare Tidmarsh, cmtidmar



import java.util.Arrays;


public class DynamicArray {
    private int array[];
    private int x;

    // default constructor to initialize the array and values
    public DynamicArray() {
        array = new int[3];
        this.x = x;
    }

    public void add(int element) {
        element = array[x];
        x++;
    }

    public Object remove(int index) {
        // create a new array for the non-deleted elements
        int[] removedInt = new int[array.length-1];
        for (int i = 0; i <= array.length; i++) {
            if (array[i] > array.length) {
                return null; // returns null if the element is not in the array
            } else {
                for (int j = i; j < removedInt.length; j++) { // traverse through length of new array
                    removedInt[j] = array[i + 1]; // add the integer to new array
                }
            }
            return Arrays.toString(removedInt);
        }
        return Arrays.toString(removedInt);
    }




    public static void main(String[] args) {

        DynamicArray array = new DynamicArray();
        // adding elements at index 0 and 1
        array.add(1);
        array.add(2);
        array.add(3);

        //array.remove(0);
        System.out.println(array.remove(1));
        System.out.println(array.remove(2));

    }

}
