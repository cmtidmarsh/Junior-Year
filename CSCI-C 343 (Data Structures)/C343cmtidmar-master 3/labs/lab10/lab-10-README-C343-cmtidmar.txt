C343 / Summer 2020
Lab - 10
July 15, 2020 16:29
Clare Tidmarsh, cmtidmar


I have a problem with executing my Hamming Distance function, so I didn't do question 5, however, one can assume that
the error at run time would be present because of the lack of memory causes a memory leak. Because the length keeps 
doubling in size, the amount of memory storage dwindles fast. So, eventually, the as you're computing the forever-doubling distances the system will run out of memory. But since it's basically an infinite loop, the previous distances are still
being used and referenced, so the system can't clear them to make room for the even bigger distances. So, an error occurs. 





The time for the Levenshtein Distance computes during every iteratation, so each line has a different time.
For instance, the Levenshtein Distance took 957555 nanoseconds.

957555
The Levenshtein Distance for line 1 is 0

Whereas the Hamming Distance took 11263 nanoseconds.

11263
The Hamming Distance for line 1 is 0

The Levenshtein functions take up considerably more time than that of the Hamming Distance because it is more complex.
The Levenshtein Distance does not need to have two strings of equal length to compute, however, the hamming distance
assumes that length of the string is the same as the other length of the string you are comparing. Since the lengths
of strings can be different, a helper function, min(), needs to be present to find the Levenshtein Distance. Since
more executions take place in the Levenshtein Distance, the more time it will take to complete. Hence, why the Levenshtein
Distance time is significantally larger than the Hamming Distance.



