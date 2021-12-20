C343 / Summer 2020
Homework - 01
June 30, 2020 8:25
Clare Tidmarsh, cmtidmar


Task A part 1: 

Results:
java.vm.version is 14.0.1+7						//Verified using version 14 
java.vm.vendor is AdoptOpenJDK
java.vm.name is OpenJDK 64-Bit Server VM
java.vm.specification.version is 14
java.vm.specification.vendor is Oracle Corporation			//Verified correct vendor
java.vm.specification.name is Java Virtual Machine Specification
java.version is 14.0.1
java.vendor is AdoptOpenJDK

Task A part 2:

Results:
Student 1 is a Finance major named Kevin. He is a junior and has 90.5 of 120 credits completed.
Student 2 is an undecided major named Jenny. She is a freshman and has 20.0 of 120 credits completed.
Student 3 is a Marketing major named Christine. She is a sophomore and has 60.5 of 120 credits completed.

---------------------------------------------------------------------------------------------------------

The results of my Student class are shown above. We can see that there are 3 students, each with a name (object 1),
major (object 2), year in school (object 3), and how many credits they have until graduation (object 4).
If you look in the code, I created methods like .setName() to give each student a name, then I also created a
.getName() to retrieve each name that was given to them. I decided to assign each student's attributes to them
when initially creating the student; then I created an array called "roster" and placed each student in the roster.
I found that, for me, this way my take a little longer but it looks more organized and just easy to navigate around.


Task B (doesn't say in hw01 to include a reflection of Task B, but still going to do it):

Results:
a DNA sequence 100 characters long: CCATGATAGTACCAAGTGGGGCCCACGTCAGGTTACCGCATACGGAAGCGAACTAAATCTCGGCGAGTGCAGCGCTAACACGGGCAAATAAGTGCTCGCT
a DNA sequence 100 characters long: AATTTATAAAGGTATGCTTGAGATTGGTGACCCCAAAGCATCAGTGAGGGGCACATACTCTACAGCTTACTCACGGGGTCATATTATGTAGCCGTTGTTA
The Hamming Distance between two strings of DNA is 71


a DNA sequence 100 characters long: TGATGATCCCATAAACGCGGTTACCGTCCAAAAGCGCTGACCAGCCAAGGTACAATAGTTGAAAAAGGGCAGAGTCCCGTTCGCATGGGTGCAATGAGAG
a DNA sequence 100 characters long: CTTCTGCGCTTCGCAGCTTACGCATCAATATGACAGCCTCAGCAAATATGATTTTGTTTATCGGGCATCCTAACGTCTTCACTTCCATGAGGTGCAGTCT
The Hamming Distance between two strings of DNA is 85


a DNA sequence 100 characters long: GACATTTAAATTAACCCACTATTGCACTGAGACCAGATGGCGACTTGCCCCAGACCTCGGACGCGTACAACAGCTTTTGGGTGTAGTACACTGGAATCGG
a DNA sequence 100 characters long: TATCAGCACGAAGCAAAGGAACATCTCGCCCTCGGTGGTCTCGCGGGACCACATTTCCAGTCTAATCGACTCCCTTGCCACCTTAGTAGCTTATATACCT
The Hamming Distance between two strings of DNA is 74

To generate two strings each being 100 characters in length, I revised the given code and turned the for-loop into a nested loop, so I can
generate the two strands of DNA that I needed for the Hamming Distance. If I recall correctly, Java only allows one return statement in
each method, so using the two strands that I randomly generated, I created an array and returned that. By creating an array, I was able to
split the 2 elements into their own values and assign then to a variable for the Hamming Distance portion. For the Hamming Distance portion,
I initialized a counter, which counts the number of times a letter from strand 1 does not match the letter in the same position from strand 2.
Then I created a for-loop that increments by 1 until i = 100, so the equation inside the for-loop recursively checks through all letters of both
Strands for equivalency or not. As you can see above, three examples of two 100 character strands where randomly generated, then the Hamming Distance
was calculated for each pairs of DNA. 


Task C:

1. For question 1, all both equations are linear such that all of the variables are constants so they both
   Perform O(n), hence, they fit the definitions of Big-O and Big-Omega where T(n) = O(h(n)) and T(n) = Omega(h(n)), so
   h(n) = n (for n steps). Since both Big-O and Big-Omega are true, then Big-Theta also exists. So Big-Theta(n) is the final
   time complexity for the two linear equations.

2. The time complexity is Big-Theta(n^2) because for each instance of "I" in "n" on the outer loop, you run it "n" times on the inner loop.
   Hence, that is why it is Big-Theta(n^2).

3. The time complexity is Big-Theta(O(n)) because you're just executing the loop "n" amount of times. So, you're running each element O(1) n times.
   Hence, you have Big-Theta(O(n)).

4. It is Big-Theta(n^2) because the nested for-loops are also cycling through "n" times, even though the first for-loop cycles through n-1 times.
   Though, we still have n when if it is n-1, and in the second for-loop it goes through the loop exact n times. So O(n*n) equals Big-Theta(n^2).



5. As one can see on the second line, the first for-loop in the nested for-loop runs from 1 to "n" times, incrementing by 1 each permutation.
   The second for-loop (line 3) also runs for log(n) times because it goes from j<=n and it increments by j*=2 times, so the j*=2 tells us the
   Second for-loop runs log(something) times. Then the arbitrary number "n", tells us how many "steps" we take. Hence, we have log(n).
   Connecting the two loops, we can say that the time complexity of the nested for-loops is Big-Theta(nlog(n)). We can see that it is valid for the
   average case because in order to get the time complexity of the algorithm, you have to break it down line-by-line and determine the individual time
   complexity of each line. Then you must bring multiply them together to get your whole time complexity for the program to get the average. This time
   complexity does not represent the upper bounds nor does it represent the lower bounds, therefore, it must represent the average between the upper
   and lower bounds.

6. The time complexity for question 6 is the same as the time complexity for question 5 (Big-Theta(nlog(n)). So again, we examine line-by-line. This time,
   however, we start with log(n) in line 2 where i*=2 defines the log(something) portion, and the i<=n defines the "n" portion in log(n). Next, we see that
   the second for-loop performs "n" times, just like it did in question 5 line 2. Hence, we get Big-Theta(nlog(n)) for the entirety of the program. This time
   complexity does not represent the upper bounds nor does it represent the lower bounds, therefore, it must represent the average between the upper
   and lower bounds.


7. For question 7, evaluating line-by-line, we can see that the first and second for-loop run "n" times, but we also have to take account for the sort
   taking n log n times. We see that for the first line, since we have "n" steps, the first for-loop runs O(n) times. Now, we can take the second for-loop.
   We can see that the second for-loop run Big-Omega(n) because we're already using O(n). According to the definition, Big-Theta(h(N)) is true if and only if
   T(N) = O(h(N) and T(N) = Big-Omega(h(N)). Assuming that h(N) = n, then both cases are true. Henve, we have Big-Theta((n)(n)). However, we know that
   sort() takes (n log n) steps, and it runs in the first for-loop. But if we simplify Big-Theta(n(n)), we get Big-Theta(n^2) and Big-Theta(n^2) is larger than
   (n log n). Hence, the time complexity is Big-Theta(n^2). 

8. 
	

