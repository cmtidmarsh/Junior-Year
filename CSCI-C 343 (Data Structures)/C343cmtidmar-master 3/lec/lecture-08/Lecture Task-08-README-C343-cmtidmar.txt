C343 / Summer 2020
Lecture Task - 08
July 3, 2020 23:49
Clare Tidmarsh, cmtidmar


"Recall the invariant concept (described in Lecture 07) :
the invariant is an "important" or "main" property of a data structure (or related algorithm) that is never violated (*) 
during the execution of an algorithm on that data structure.
(*) e.g. if any single operation on the data structure, during the execution of an algorithm, violates the invariant property,
then that operation has to restore the invariant property right away, before the operation concludes.
Analyze the Insertion Sort algorithm, and provide an answer to these questions:


what is Bubble Sort's invariant ?
why may we consider Bubble Sort's invariant to be "stronger" than Insertion Sort's invariant?
Due by 11:59PM on Friday, July 03, 2020."


The Bubble Sort's invariant is for any iteration "i", where "i" goes from 1 (quantifying 1 to be the largest sorted)
to n - 1; the iteration of "i" reflects the  "i" largest numbers sorted at the end of array "a". 

We consider Bubble Sort's invariant to be stronger than Insertion Sort's invariant because for each iteration, Bubble Sort
is a stable sort meaning that you can guarantee that the right most items are the largest sorted items in the array whereas
Insertion Sort is an unstable sort meaning that while the current array is sorted, the elements in the array are not
necesarrily the smallest in the whole array.
