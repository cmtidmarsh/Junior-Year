//        C343 / Summer 2020
//        lab mini assignment - 06
//        July 3, 2020 22:47
//        Clare Tidmarsh, cmtidmar

public class StaticArray{
    public static int[] integerArray = {1, 2, 3, 4, 5};

    public Object removeAt(int index) {
        // create a new array for the "removed" element with the same length as the old array
        int[] removedInt = new int[integerArray.length];

        // Iterate through the length of the array first array
        for (int i = 0; i < integerArray.length; i++) {
            if (integerArray[i] == integerArray[index]) { // If "i" value equals the desired index number
                removedInt[i] = Integer.parseInt(null); // replace the desired element with null
            }

    }
        return index;
    }




    public static void main(String[] args) {
        System.out.println(integerArray.length);
        //System.out.println(Arrays.toString(integerArray.removeAt(0)));


}
}
