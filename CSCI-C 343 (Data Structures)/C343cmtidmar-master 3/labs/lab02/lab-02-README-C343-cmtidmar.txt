
C343 / Summer 2020
Lab Mini Assignment-02
June 25, 2020 15:41
Clare Tidmarsh, cmtidmar

For TheRunTimes assignment, I chose example 2 because I thought it would be similar to
Example 1 in the lecture. So, I went over example 1 in the lecture and how Prof. Hmeljak
explained it, which helped a fair amount when approaching example 2.However, I was stuck on how 
to make one countInstructions method for both problems (example 2 and 7). So in turn, I decided
on making countInstructions method for example 2 and a countInstructions2 method for example 7 in
the CalculateRunTimes class. Also, seeing that in example 7, there are are "m" and "n" variables in
the nested for-loop, I decided to create two parameters (int n) and (int m). The separate countInstructions2
method helps with dealing with that because example 2 only has one variable, n, in the nested for-loop, so it
only needs one parameter (int n). So creating two countInstructions allows us to account for the necessary parameters
for each example.

The results for both examples returned from the program as follows:

Example 2:
n = 10		instructioncounter = 101	(instructioncounter/n)= 10
n = 100		instructioncounter = 10001	(instructioncounter/n)=	100
n = 1000	instructioncounter = 1000001 	(instructioncounter/n)= 1000
n = 10000	instructioncounter = 100000001	(instructioncounter/n)= 10000


Example 7:
n = 10		instructioncounter = 162 	(instructioncounter/n)= 16
n = 100		instructioncounter = 19602	(instructioncounter/n)=	196
n = 1000	instructioncounter = 1996002	(instructioncounter/n)= 1996
n = 10000	instructioncounter = 199960002	(instructioncounter/n)= 19996


The instructioncounter shows us how many steps the program takes for each value of n. Now, using the 
(instruction/n) calculation, we can estimate how high or low the time complexity is for that program to perform.
The higher the time complexity, the more functions the program performs, hence, the more inefficient the program
is. If the program has a lower time complexity, the less functions it performs, hence, the more efficient
the program is to use.

For example 2, can see that the value of (instructioncounter/n) calculates to be the same as each of the values of
n. So, comparing those two, we can see that the time complexity for example is high and likely to have the
Time complexity of O(n^2). Referring back to Lecture 03's notes, we can see that example 2, compares on the graph of 
Figure 3.1 to the (10n) line. However, example 7 shows us that the time complexity is going to be even higher, or worse,
compared to example 2. Also referring back to Figure 3.1 of lecture 03, we notice that example 7's results are close to the
line of (2n^2) which performs more functions than (10n), hence, a higher time complexity.

Just going off the results on the table, we take the ratios of n:(instructioncounter/n). We can note that the higher the ratio,
The higher/less efficient the time complexity will be. From example 2, we see that the ratios are
10:10, 100:100, 1000:1000, and 10000:10000, however, example 7
has the ratios 10:16, 100:196, 1000:1996, and 10000:19996. Comparing the two examples we can see that
Example two has smaller ratios and a lower time complexity than example 7, hence, example 2 is more efficient than example 7. 
