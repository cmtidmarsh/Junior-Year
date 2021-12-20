C343 / SUMMER 2020
Homework - 04
July 19, 23:19
Clare Tidmarsh, cmtidmar

Task A. Java implementation
-------------------------------------------------------------------------------------------------------------------
Task B. 


1. Consider the following operations on a set of numbers.
   a. Find the minimum value.
   b. Find the maximum value.
   c. Compute the arithmetic mean.
   d. Find the median, i.e.: the middle value.
   e. Find the mode, i.e.: the value that appears the most times.
  
Which operations are best implemented by first sorting the list of numbers?

The operations that are best implemented by first sorting the list of numbers are Option A) Find the minimum value,
Option B) Find the maximum value, and Option D) Find the median.

Option A) Find the minimum value - If you don't sort the sort before calling a find minimum value function then the find
minimum needs to start with the first element in the list and store it as the minimum element, then iterate through the
list comparing every element to the mimimum and continuously store the smallest until the last element is evaluated and 
the minimum value is found. However, if you sort the list of numbers first then you need to only get the first element if
the elements were sorted from acending or you need to get the last element if it is sorted from descending in numerical 
value.

Option B) Find the maximum value - The same algorithm applies to the maximum value as it did in the minimum value. If you
don't sort the sort before calling a find maximum value function then the find maximum needs to start with the first element
in the list and store it as the maximum element, then iterate through the list comparing every element to the maximum and 
continuously store the largest (max) until the last element is evaluated and the maximum value is found.

Option D) Find the median - In order to find the median you first need to sort the numbers in order. If there are an even
number of elements in the list, then iterate through the first and the last elements moving inward one element at a time
until the last two elements are found in the middle of the list. Then add the values of those two elements, then divide by
2, to get the median. If there are an odd number of elements in the list, then iterate through the first and last elements
moving inwards one element at a time pairing one element from the right and left together until you get the last number that
cannot be paired. That is your median.
 

For each operation, describe an algorithm to implement the operation, with a brief description about how your chosen 
algorithm solves the requested operation.

Option A) Find the minimum value:
--------------------------------
    public static int findMin(int[] array) {
        int currentMin = array[0];  // Initialize the minimum value to be the first element in the list
        for (int i = 0; i < array.length; i++){ // for each element in the list
            if (array[i] < currentMin){ // if the next element in the list is greater than the current minimum
                currentMin = array[i]; // set the new current minimum
            }
        }
        return currentMin; // return the minimum number

Option B) Find the maximum value:
--------------------------------
    public static int findMax(int[] array) {
        int currentMax = array[0];  // Initialize the maximum value to be the first element in the list
        for (int i = 0; i < array.length; i++){ // for each element in the list
            if (array[i] > currentMax){ // if the next element in the list is greater than the current maximum
                currentMax = array[i]; // set the new current maximum
            }
        }
        return currentMax; // return the maximum number
    }
    
Option C) Compute the arithmetic mean:
-------------------------------------
public static double mean(int[] array) { // takes in an integer list
        double mean = array[0]; // start with the first element value in the list
        for (int i = 1; i < array.length; i++) { // iterate through each element in the list
            mean += array[i]; // add the current mean to the next element
        }
       return mean / array.length; // return the sum of all element values in the list divided by how many elements in the list
   }

 Option D) Find the median:
 --------------------------------

 
Option E) Find the mode:
--------------------------------
public void mode(int[]array){
		int mode = array[0];	// initialize mode to the first value in array[0]
		int count = 0;	// initialize the count to 0 frequency
		for (int i = 0; i < array.length; i++) { // for each element in array
			for (int j = 1; j < array.length ; j++){ // for each next element in array
				if (array[i] == array[j]){ // if the value at array[i] and the value at array[j] is the same
					count++; // increment counter by one
				}
			}
}
}


State the asymptotic complexity for each operation to be completed.

Option A) Find the minimum value: O(n)
Option B) Find the maximum value: O(n)
Option C) Compute the arithmetic mean: O(n)
Option D) Find the median:  O(nLogn)
Option E) Find the mode: O(n)


2. The following problems are about sorting numbers (all these are comparison-based) :

Write an algorithm to sort three numbers. It should make as few comparisons as possible. In your answer, provide a complete
pseudocode implementation. Explain exactly how many comparisons and swaps are required in the best, worst, and average 
cases?

- Initialize the list of 3 numbers 
- find the minimum value in the array

- case 1: the minimum value is at the first position, then check the second and third position values
   - if third position value is less than second position value
      - swap values of third position and second position
   - else, print a sorted array message
   
- case 2: the minimum value is not at the first position,
   - swap the value at the first position and the position that the minimum value is at
   - if third position value is less than second position value
      - swap values of third position and second position
   - else, print a sorted array message


int[] array = {2, 3, 1};
public void threeNumSort(int[] array){

// finds the minimum value in the array
int minimum = array[0]; // starts with the first element
for (int i = 0; i < array.length; i++) { // iterates through each element in the array 
   if (array[i] < minimum) { // if another value at a different position is less than current minimum, then replace min value
        minimum = d[i];

case 1: minimum == array[0]{ //{1, 3, 2}
      if (array[2] < array[1]){ 
         swap(array[2], array[1]); } //{1, 2, 3}
      else {
         System.out.println("sorted");
         }
         
case 2: minimum != array[0]{
      swap(min, array[0]);
      if (array[2] < array[1]){ 
         swap(array[2], array[1]); } //{1, 2, 3}
      else {
         System.out.println("sorted"); }
         
  Best
--------
 The best case would make 2 comparisons and 0 swaps, because the minimum value is already at the first position, we would only
 have to perform case 1 because the minimum value is at the first position, array[0], and is already sorted. 
 Then you have to only compare the second and third values in the other 2 positions, array[1] and array[2]. If second value is
 less than the third value, then the array is already sorted. Hence, only making one comparison between array[1] and array[2]
 and 0 swaps because it is already sorted.
 
 Average
 -------
 Using case 1, the average case would make 2 comparison and 1 swap because the minimum value is already at the first position,
 we would only have to compare the second value and third value at positions 2 and 3. If the value at the third position,
 array[2], is less than the value at the second position, array[1], then swap the two values. Then, you will have a sorted
 array of 3 numbers.
 
 Using case 2,the average case would make 2 comparisons and 1 swap. if the minimum value is not at the first position, then 
 swap the minimum value and the value at the first position. This will change the values at the positions, so the minimum 
 value is at the first position. Then compare the values at the second and third positions. If the value at the seond
 position is less than the value at the third position then print a sorted array statement. Hence, only one swap was made
 between the minimum value position and the value at the first position in the array. 
 
 Worst
 -----
 The worst case would make 2 comparisons and 2 swaps because the minimum value is not already at the first position, so
 you will have to swap the value at the first position with the minimum value and its position. Then if the value at the
 third position is less than the value at the second position, you will also have to swap those two values. After making
 2 comparisons and 2 swaps you will have a sorted array.
   

Write an algorithm to sort five numbers. It should make as few comparisons as possible. Explain exactly how many comparisons
and swaps are required in the best, worst, and average cases?
Hint: use your solution for problem (a.) above as a starting point for solving this problem (b.), by adding the 4th and 5th
number on the top of the sorted ouput of your pseudocode for problem (a.).

- call threeNumSort, sorts the first 3 numbers in the array, and saves in a copy
- create a new array of 5 positions with the sorted copy and 2 more values in the remaining positions
- iterate through the array list, and compare all values with the two new values (array[3] and array[4])
   - if newArray[3] is less than newArray[i]
      - swap newArray[3], newArray[i]
   - if newArray[4] is less than newArray[i]
      - swap newArray[4], newArray[i]
 

public void fiveNumSort(){
int[] sorted = threeNumSort(array);
int[] newArray = {sorted[0], sorted[1], sorted[2], 4, 5};
for (int i = 0; i < newArray.length; i++){
   if (newArray[3] < newArray[i]){
      swap (newArray[3], newArray[i]);}
      
   if (newArray[3] > newArray[i] && newArray[3] < newArray[4]){
      System.out.println("sorted");}
      
   if (newArray[4] < new Array[i]){
      swap(newArray[4], newArray[i]); }
      }
   if (newArray[4] > newArray[i] && newArray[4] > newArray[3]){
      System.out.println("sorted");
      }
   else {
   System.out.println("sorted"); }
   
      }
  Best
--------
The best case is making addional i<10 comparisons and 0 swaps to the threeNumSort() comparisons
because you have to iterate through and compare newArray[3] and newArray[4] to all of the previous elements. Then if the
value at newArray[3] is greater than the previous elements, but also less than the last element, then the array is sorted. 
Likewise for array[4], if we iterate through all of the elements and determine that newArray[4] > newArray[3], then the array
is sorted.

 Average
 -------
 The average case is making additional i<10 comparisons and i<10 && i>0 swaps to the threeNumSort() comparisons because you
 can only compare each element with either newArray[4] or newArray[5], 5 times each. However, 10 comparisons is anything
 less than the max number of comparisons and the number of swaps would also be anything less then the max number of swaps but
 also greater than 0 swaps (the best case). Hence, i<10 comparisons and i<10 && i>0 swaps in addition to the comparisons and
 swaps you make in the threeNumSort().
 
  Worst
 -----
 The worst case is making 10 comparisons and 10 swaps in additon to the threeNumSort() comparisons because if you have to
 iterate through and compare each individual to either the forth or fifth element, then you would be making 5 comparisons
 each, making it out to be 10 comparisons total. Then if you have to swap either the forth or fifth element each time you 
 compare, then you would have 10 swaps in total along with the 10 comparisons.
 
[optional question: 10 points bonus]
Write an algorithm to sort eight numbers. It should make as few comparisons as possible. Again, you need to explain: exactly 
how many comparisons and swaps are required in the best, worst, and average cases?

- takes in an array
- call fiveNumSort and sort the first 5 numbers in the array
- save the new sorted array in a copy 
- create a new array of 8 positions with the sorted copy and 3 more values in the remaining positions
- iterate through the array list, and compare all values with the three new values (array[5], array[6], and array[7])

public void eightNumSort(){
int[] sorted = fiveNumSort(array);
int[] newArray = {sorted[0], sorted[1], sorted[2], sorted[3], sorted[4], 9, 0, 10};
for (int i = 0; i < newArray.length; i++){
   if (newArray[5] < newArray[i]){
      swap (newArray[5], newArray[i]);}
      
   if (newArray[5] > newArray[i] && newArray[5] < newArray[6] && newArray[5] < newArray[7]){
      System.out.println("sorted"); }
      
   if (newArray[6] < new Array[i]){
      swap(newArray[6], newArray[i]); }
   
   if (newArray[6] > newArray[i] && newArray[6] > newArray[5] && newArray[6] < newArray[7]){
      System.out.println("sorted"); }
      
   if (newArray[7] < new Array[i]){
      swap(newArray[7], newArray[i]); }
    
   if (newArray[7] > newArray[i] && newArray[7] > newArray[5] && newArray[7] > newArray[6]){
      System.out.println("sorted");}      
   
      }
   }
