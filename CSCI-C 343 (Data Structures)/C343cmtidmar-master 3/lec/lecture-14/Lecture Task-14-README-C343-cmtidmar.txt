
C343 / Summer 2020
Lecture Task - 14
July 15, 15:17
Clare Tidmarsh, cmtidmar

"Lecture 14 Task - C343 Summer 2020
To find the k largest (or k smallest) elements in an array using a Max-Heap (or a Min-Heap), what would be the asymptotic time complexity?
To find the k largest (or k smallest) elements in an array using the Heapsort algorithm, what would be the asymptotic time complexity? (and is that different than question 1. above?)
Given that n is the size of the problem, k is the number of elements we want to find, does the time complexity depend on n, k, or both n and k ?
Due by 04:30PM on Wednesday, July 15, 2020.
Follow C343 Submission Instructions about naming your file, file content type, encoding, and submission.
(see Lecture 14 video if you could not attend the Zoom meeting for Lecture 14 on Tuesday July 14)"


1. The asymptotic time complexity of an array to find the k largest (or k smallest) elements in an array using
a Max-Heap (or a Min-Heap) sort is O(k*log n) as max-Heap  (or Min-Heap) would have to be done k times to find 
the k largest (or smallest) elements and each search has a complexity of O(log n).

2. The asymptotic time complexity of an array to find the k largest (or k smallest) elements in an array using
Heapsort is O(n + k*log n) as it would first take O(n) to sort through the whole array and then k times to find
the k largest (or smallest) elements and each search has a complexity of O(log n). This is different than question
1 as the array here is unsorted while the first one is already either through Max-Heap or Min-Heap.

3. Both n and k affect the duration of the problem. Keeping n constant, increasing k increases the duration of the 
problem as we want to find more k elements,therefore, the longer it will take as the search for each element takes
O(log n). Keeping k constant, increasing n increases the duration of the problem as we are finding the same k elements
but in a longer array and therefore affects the search time of each element as n is a function of the time in O(log n).
