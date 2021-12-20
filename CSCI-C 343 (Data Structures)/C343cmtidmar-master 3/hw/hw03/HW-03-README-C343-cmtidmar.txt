C343 / Summer 2020
Homework - 03
July 15, 2020 12:06
Clare Tidmarsh, cmtidmar

1. is the 2D array guaranteed to be "fully sorted" after calling sortArray1()?
If yes, how can you show that it always gets fully sorted?
If not, why not?

Yes, it should be because it doesn't matter what order the sortColumns and sortRows functions are in. For example,

if you have an array, [5, 2, 7, 1, 4]
                      [3, 6, 1, 0, 9]
 and first sort the columns,
 
                      [3, 2, 1, 0, 4]
                      [5, 6, 7, 1, 9]
                      
then sort the rows,

                      [0, 1, 2, 3, 4]
                      [1, 5, 6, 7, 9]
                      
the end result would be, 
                      [0, 1, 2, 3, 4]
                      [1, 5, 6, 7, 9]
                      
which is fully sorted from acending order.
 

2. is the 2D array guaranteed to be "fully sorted" after calling sortArray2()?
If yes, how can you show that it always gets fully sorted?
If not, why not?


Yes, it should be because it doesn't matter what order the sortColumns and sortRows functions are in. For example,

if you have an array,  
                      [5, 2, 7, 1, 4]
                      [3, 6, 1, 0, 9]
                      
 and first sort the rows,
                      [1, 2, 4, 5, 7]
                      [0, 1, 3, 6, 9]
                      
then sort the columns,
                      [0, 1, 3, 5, 7]
                      [1, 2, 4, 6, 9]
                      
the end result would be, 
                      [0, 1, 3, 5, 7]
                      [1, 2, 4, 6, 9]
                      
which is fully sorted from acending order. 

3. what are the asymptotic complexities of sortArray1() and sortArray2()?
Since Bubble Sort is used in both, sortColumns and sortRows, the time complexity should be O(n^2) for both
sorting functions. So the time complexity for sortArray1() and sortArray2() should be O(n^2)*O(n^2) =  O(n^4).

4. what is the actual running time of your sortArray1() and sortArray2() methods?
To answer this question, you will need to time your two methods, for example thus:

SortArray1 - 130971
SortArray2 - 63011

5. If the running times of sortArray1() and sortArray2() differ substantially, provide your explanation about what
may cause that difference in running times.
SortArray1, where sortColumns is ran first then sortRows is ran second, runs the longest possibly because in SortArray2
the rows are first sorted, so then it sortRows gives some guidence to sortColumns since the rows are already sorted from
lowest to highest, so the sortColumns just has to check the columns and make minor changes if there are two elements
not in order regarding columns. Whereas, if you sortColumns first, there is no guidence from sortRows.
