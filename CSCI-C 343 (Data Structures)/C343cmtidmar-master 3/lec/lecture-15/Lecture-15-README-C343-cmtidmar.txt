C343 / Summer 2020
Lecture Task - 15
July 16, 2020 14:46
Clare Tidmarsh, cmtidmar

"Lecture 15 Task - C343 Summer 2020
Evaluate both Time and Space Asymptotic Complexity of one of these algorithms:
Insertion Sort
Bubble Sort
Merge Sort
Heap Sort
then compare the Time and Space Asymptotic Complexity of one of the above four (comparison-based) sorting algorithms to the
Time and Space Asymptotic Complexity of Counting Sort. Due by 4:30PM on Thursday, July 16, 2020.
Follow C343 Submission Instructions about naming your file, file content type, encoding, and submission.
(see Lecture 15 video if you could not attend the Zoom meeting for Lecture 15 on Tuesday July 15)"


The time complexity for Bubble Sort is O(n) at the best case, where the best case are minimal spaces moved. Meaning that
only one iteration through the data takes place. For instance, if you have an array of [2, 1, 4, 3] and use Bubble Sort,
you compare the first and second element [2, 1]. They aren't in order, so Bubble Sort will switch them [1, 2]. Now, the
array is [1, 2, 4, 3]. Next, compare [2, 4]. [2, 4] are in order, so compare [4,3]. 4 is greater than 3, so Bubble Sort will
switch the two [3, 4]. Now the array is sorted [1, 2, 3, 4]. The average and worst case for Bubble Sort is O(n^2) because if
it isn't the best case, then the only other option is to perform all of the switches you can within the rules of Bubble Sort
for one iteration, then you're have to repeatedly use Bubble Sort starting from the first to the last element each time you
finish the array until it gets fully sorted. Therefore, the space complexity is O(1) because Bubble sort can only hold one
dataset at a time to be able to sort the data in the array. 
