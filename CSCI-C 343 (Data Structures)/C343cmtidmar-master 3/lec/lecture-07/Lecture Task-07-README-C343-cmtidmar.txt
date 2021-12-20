C343 / Summer 2020
Lecture Task - 07
July 2, 2020 15:44
Clare Tidmarsh, cmtidmar

Insertion Sort
// input: an array A of values that can be sorted
// output: the same array A, sorted
// invariant: the first j elements in the array are sorted
    n = length(A)
    for j increasing from 1 to n-1 :
       for i decreasing from j to 1:
          if ( A[i-1] > A[i] ) then :
             swap(A[i-1], A[i])


Analyze the Insertion Sort algorithm, and provide an answer to these questions:
determine the running time T(n) of the algorithm
determine Big-O, Big-Ω, Big-Θ for the algorithm

Running Time T(n) = O(n). 
Big-O = O(n^2)
Big-Ω = Ω(n)
Big-Θ = Θ(n^2)




