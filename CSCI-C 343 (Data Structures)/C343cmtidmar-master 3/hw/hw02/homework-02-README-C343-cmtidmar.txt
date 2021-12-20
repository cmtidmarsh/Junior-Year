C343 / Summer 2020
Homework - 02
July 7, 2020 9:57
Clare Tidmarsh, cmtidmar


Task A. Java implementation - (NOTE: I know it's wrong, but I thought what the code produced when I tried implementing
the ranges with the black, grey, and white was more interesting than just not including the Task A code. Also, in my original
Int2DArrayADT file, I also put the Int2DArray class in it too, so I just referred from the one file.)
-------------------------------------------------------------------------------------------------------------------------
Task B. 

1) Assume a list has the following configuration: <|2, 23, 15, 5, 9>.
Using one of the List ADT (written in Java) as seen at Lecture 05, write a series of Java statements to delete the element with value 15.
(note: we're not considering a Java Collection type here: we're only considering one of the possible List ADTs as seen at Lecture 05)
Provide a thorough explanation for your answer.

Since the list has few elements, we can use an array-based list abstract data type.
A linked list is ideal for only wanting to remove the first element in the list.
However, since the desired element, 15, is in the middle of the list, we can index to that element and remove it,

List<Integer> arrayList = new ArrayList<>(); // <2, 23, 15, 5, 9>.
arrayList.insert(2);
arrayList.insert(23);
arrayList.insert(15);
arrayList.insert(5);
arrayList.insert(9);
arrayList.setCurr(0); // sets pointer to first element, which is 2. <|2, 23, 15, 5, 9>.

Public void remove(int index){
	arrayList.mvToPos(index); // move to the desired position <2, 23, |15, 5, 9>.
	System.out.println(arrayList.get()); // to make sure you have the correct element <2, 23, 15|, 5, 9>.
	arrayList.delete(); // deletes the element  <2, 23, 5, 9>.

Using the List ADT, we can create the array-based list, then use the .insert(E item) function to insert all of
the integer elements. Then use the .setCurr(int i) to set the current position of the pointer.
Since the pointer is at 2, we want to set the current position of the pointer to be at the first element,
also known as element[0]. Next, We can create the remove method, which will have the type "void" and the parameter
will be (int index), so public void remove(int index). Inside the function, we want to use the .mvToPos() function
and have it take in "index" (arrayList.mvToPos(index)).
This will then move the pointer's position to our desired index within the list. 
In addition, as an extra step to check to make sure we have the right element, use the .get function and print out the value
of .get (System.out.println(arrayList.get()). The value should be at 15, since 15 is the desired index number.
Once verified, use the .delete() function to remove the desired index (arrayList.delete()) in the list. 
Now the index number should be deleted and the list should look like this: <2, 23, 5, 9>.

2) Determine the break-even point for an array-based list and linked list implementation for lists when the
sizes for the data field, a pointer, and the array-based list's array are as specified below.
State when the linked list needs less space than the array.

Formula for Break-Even Point: n > (DE)/(P+E)

n is the number of elements currently in the list,
D is the length of the array-based list,
E is the size of a data element,
and P is the size of a pointer.


a. The data field is eight bytes, a pointer is four bytes, and the array holds 20 elements.
   
n > (20*8)/(4+8)
n > 160/12
n > 13.333
However, if n > 13.333, then there would not be enough space because by calculating the maximum required space (D*E),
we get 160 bytes, and by calculating the amount of space needed for one element (P+E), we get 12 bytes. 
So we require a maximum space of 160 bytes for the total list, and 12 bytes per element.
Using this we can let n*12 <= 160, where n is the number of elements in the list. 
If we were to let n = 14, which 14 > 13.333, then 14*12 = 168 which is not less than or equal
to 160, our maximum capacity. Hence, we can have up to 13.333, or if only using whole numbers rounding down to
n <= 13.
              
b.The data field is two bytes, a pointer is four bytes, and the array holds 30 elements.

n > (30*2)/(4+2)
n > 60/6
n > 10

However, if n > 10, then there would not be enough space because by calculating the maximum required space (D*E),
we get 60 bytes, and by calculating the amount of space needed for one element (P+E), we get 6 bytes. 
So we require a maximum space of 60 bytes for the total list, and 6 bytes per element.
Using this we can let n*6 <= 60, where n is the number of elements in the list. 
If we were to let n = 11, which 11 > 10, then 11*6 = 66 which is not less than or equal
to 60, our maximum capacity. Hence, we can have up to 10, so n <= 10.


c. The data field is one byte, a pointer is four bytes, and the array holds 30 elements.

n > (30*1)/(4+1)
n > 30/5
n > 6

However, if n > 6, then there would not be enough space because by calculating the maximum required space (D*E),
we get 30 bytes, and by calculating the amount of space needed for one element (P+E), we get 5 bytes. 
So we require a maximum space of 30 bytes for the total list, and 5 bytes per element.
Using this we can let n*5 <= 30, where n is the number of elements in the list. 
If we were to let n = 7, which 7 > 6, then 7*5 = 35 which is not less than or equal
to 30, our maximum capacity. So we would not be able to store all 7, hence, we can have up to 6, so n <= 6.

d. The data field is 32 bytes, a pointer is four bytes, and the array holds 40 elements.

n > (40*32)/(4+32)
n > 1280/36
n > 35.555

However, if n > 35.555, then there would not be enough space because by calculating the maximum required space (D*E),
we get 1280 bytes, and by calculating the amount of space needed for one element (P+E), we get 36 bytes. 
So we require a maximum space of 1280 bytes for the total list, and 36 bytes per element.
Using this we can let n*36 <= 1280, where n is the number of elements in the list. 
If we were to let n = 36, which 36 > 35.555, then 36*36 = 1296 which is not less than or equal
to 1280, our maximum capacity. So we would not be able to store all 36, hence, we can have up to 35.555, or if
only using whole numbers rounding down to n <= 35.
              

-------------------------------------------------------------------------------------------------------------------------
Task C. 

1) The following expressions, in order from slowest to fastest, is as follows:

2, log3n, log2n, n^2/3, 20n, 4n^2, n!, 3^n
            
we can determine the slope, or rate of change, by using the derivative of each of these expressions then by
plugging in a constant value to determine a numerical value for all expressions, so let's use n = 5. 
           
For 4n^2,
d/dx(4n^2) = 8n
hence, the rate of change is 8n and when n = 2, 8*5 = 40.
           
For log3n,
d/dx(log3n) = 1/(nln(3))
hence, the rate of change is 1/(nln(3)) and when n = 2, 1/(2ln(3)) = ~0.18204
           
For n!, we can simply compute the factoral of our constant. So when n = 5, 5! = 120.
           
For 3^n,
d/dx(3^(n)) = 3^(n)ln(3)
hence, the rate of change is 3^(n)ln(3) and when n = 2, 3^(5)ln(3) = ~266.96278.
           
For 20n, 
d/dx(20n) = 20.
hence, the rate of change is 20.
           
For 2,
d/dx(2) = 0
hence the rate of change is 0. 
           
For log2n, 
d/dx(log2n) = 1/(nln(2))
hence, the rate of change is 1/(nln(2)) and when n = 5, 1/(5ln(2)) = ~0.28853.
           
For n^(2/3),
d/dx(n^2/3) = 2/(3n^(1/3))
hence, the rate of change is 2/(3n^(1/3)) and when n = 5,  2/(3(5)^(1/3)) = ~0.38986.
           
By using the derivative, we can find the rate of change. Then, by using a constant value of all n, we can then
use the numerical value to double check the rate of change because numerical values are much simpler to use when
putting items in a particular order. Hence, the order of growth rate from slowest to fastest is,
          
2, log3n, log2n, n^(2/3), 20n, 4n^2, n!, 3^n
            
2) Using the definitions of Big-O and Big-Ω, find the upper and lower bounds for the following expressions:

Recalling Big-O and Big-Omega definitions from Lecture04:
     
Big-O: Let T(n) represent the true running time of the algorithm. f(n) is some expression for the upper bound.
       For T(n) a non-negatively valued function, T(n) is said to be set O(f(n)) if there exist two positive
       constants c and n0 such that T(n)≤cf(n) for all n>n0. 
       The constant n0 is the smallest value of n for which the claim of an upper bound holds true.
            
Big-Omega: T(n) represents the true running time of the algorithm. g(n) is some expression for the lower bound.
           For T(n) a non-negatively valued function, T(n) is in set Ω(g(n)) if there exist two positive 
	   constants c and n0 such that T(n)≥cg(n) for all n>n0.
	   
	   a. c1n
	   Big-O: Assume T(n) = C1n for c1 > 0. Then C1n <= C1n for all n > 1. So T(n) <= cn for c = c1 and n0 = 1. Therefore,
	   T(n) is O(n) by definition.
	   
	   Big-Omega: Assume T(n) = C1n for c1 > 0. Then C1n >= C1n for all n > 1. So T(n) >= cn for c = c1 and n0 = 1. 
	   Therefore, T(n) is Omega(n) by definition.
	   
	   b. c2n3 + c3
	   
	   Big-O: Assume T(n) = C2n^3+C3 for c2 > 0 and C3 > 0. Then C2n^3+C3 <= C2n^3 + C3n^3 <= (C2 + C3)n^3 for all n > 1.
	   So T(n) <= cn^3 for c = c2+c3 and n0 = 1. Therefore, T(n) is O(n^3) by definition.
	   
	   Big-Omega: Assume T(n) = C2n^3+C3 for c2 > 0 and C3 > 0. Then C2n^3+C3 >= C2n^3 for all n > 1. So T(n) >= cn^3 for 
	   c = c2 and n0 = 1. Therefore, T(n) is Omega(n^3) by definition.
	   
	   
	   c. c4n log2n + c5n
	   
	   Big-O: Assume T(n) = c4n log2n + c5n for c4 > 0 and C5 > 0. Then c4n log2n + c5n for c4 <= c4n log2n + c5n log2n <= 
	   (c4 + c5)n logn for c = (c4 + c5) for all n > 1. So T(n) <= cn logn for c = c4+c5 and n0 = 1. Therefore, T(n) is 
	   O(n logn) by definition.
	   
	   Big-Omega: Assume T(n) = c4n log2n + c5n for c4 > 0 and C5 > 0. Then c4n log2n + c5n >= c4n log2n for all n > 1. So 
	   T(n) >= cn log2n for c = c4 and n0 = 1. Therefore, T(n) is Omega(n log2n) by definition.
	   
	   d.c6 2^n + c7n^6
	   
	   Big-O: Assume T(n) = c6 2^n + c7n^6 for c6 > 0 and C7 > 0. Then c6 2^n + c7n^6 <= c6 2^n + c7 2^n <= (c6 + c7) 2^n 
	   for all n > 1. So T(n) <= c 2^n for c = c6+c7 and n0 = 1. Therefore, T(n) is O(2^n) by definition.
	   
	   Big-Omega: Assume T(n) = c6 2^n + c7n^6 for c6 > 0 and C7 > 0. Then c6 2^n + c7n6 >= c7n^6 for all n > 1. So 
	   T(n) >= cn^6 for c = c7 and n0 = 1. Therefore, T(n) is Omega(n^6) by definition.
            
        
        3) For the following code fragment, determine Θ in the average case:
	
	sum = 0;
	if (EVEN(n)){
		for (int i = 0; i<n; i++){
		sum++;
		}
	} else {
		sum = sum + n;
	}
	
	The worst case is Big-O(n) because in the case where n is even, you have to iterate through all of n.
	The best case is Big-Omega(1) because in the case where n is odd, you only need to execute the program once. 
	The average case is Big-Theta(n/2) because n can only be either even or odd, and the efficiency when n is even is 
	O(n) and the efficiency when n is odd is O(1). Because there's equal chance of getting either an even or odd number, 
	Big-Theta would be the average of both efficiencies.
-------------------------------------------------------------------------------------------------------------------------     
Task D. 

1) In java document "TaskDPart1.java" https://github.iu.edu/C343-Summer2020/C343cmtidmar/blob/master/hw/hw02/TaskDPart1.java


2) Why is the BST Property defined so that nodes with values equal to the value of the root appear only in the right subtree,
 rather than allow equal-valued nodes to appear in either subtree? Note: at lecture time we initially allowed nodes with equal
 values to appear in either left or right subtrees. However, in a more precise definition of the BST Property --as mentioned 
 in this textbook exercise-- we always select only one of the two subtrees to store nodes with equal values. 
	
BST Property is defined so that nodes with values equal to the value of the root appear only in
the right subtree, rather than allow equal-valued nodes to appear in either subtree. Here, we can define part a of
the question as sorted values, and part b of the question can be represented as the unsorted values. If we use a list
of unsorted nodes, the time efficiency goes down because we have to traverse through each node using O(n) time.
However, if we use a list of sorted nodes, we don't have to go through each and every element, hence, making
the efficiency faster.
        
3) About BSTs:


a. Show the BST that results from inserting the values 15, 20, 25, 18, 16, 5, and 7 (in that order):
        
                                                15, 5, 20, 7, 18, 25, 16
                                          
First, the root is 15. Then 15 has two children 5 (on leftside) and 20 (on rightside). Now, moving down a level,
we notice that 5 has only one child, so tier 3 on the left tree will have the value 7, whereas on the as tier but
on the right tree 20 has 2 children: 18 (on left) and 25 (on right). Finally, we notice that there's a tier 4 only
containing one child from 18, and that is the value of 16.
        
b. Show the enumerations for the tree obtained from the above step (a), that result from doing a pre-order traversal, 
an inorder traversal, and a postorder traversal.

Pre-order: 15, 5, 7, 20, 18, 16, 25
Inorder: 5, 7, 15, 16, 18, 20, 25
Postorder:7, 5, 16, 18, 25, 20, 15
        
4) a. An array-based list of unsorted records would be most appropriate because the question     
	states that the records are guranteed to arrive already sorted from lowest to highest. From
        there, we can immediately eliminate choice (1), choice (3), and choice (4) because we won't need
        a data structure that sorts the records since they are already guaranteed to be sorted. Which
	leaves us with the possiblity of choice (2) and choice (5). From the two left, we can determine
        choice (5) is the best because we can use the disvantage of the array-based list as an advantage.
	The disvantage states that "size must be predetermined; wasted space for lists with empty slots".
	Here, we don't have any empty slots. We have exactly 1000 inserts that will be iterspersed with exactly
	1000 searches, therefore, the predetermined size is not a problem for this question, as well as there
	is no wasted space for empty slots because we have exactly 1000 inserts and 1000 searches. 
	Hence, an array-based list of unsorted records.
             
   b. An array-based list of unsorted records is most appropriate for this question. As the number of insertions are high it 
  	 eliminates choice (3) the insertion complexity of this choice would make this scenario take too much time. This 
	 leaves choices (1) (2) (4) and (5). Because the size of the data is already known this rules out choices (1) and (2) 
	 and leaves us with choices (4) and (5) as an array is preffered. Given that the problem states that the values have 
	 uniform random distribution then the most efficient choice would be an array-based list of unsorted records.
           
   c. A binary search tree is the most appropriate for question C. Here, we can also see 
      (like in question A) that the number of insertions and searches are the same/are equal.
      However, the question mentions that the records arrive with values having a uniform random distribution,
      whereas, question A was already sorted. The binary search tree allows you to perform binary search
      without the records being sorted.
      Considering the question states "values having a uniform random distribution", sorting the records would 
      not be very ideal. Hence, comparing randomly distributed records would be most ideal with a binary
      search tree (BST). 
              
   d. A binary search tree is the most appropiate option as the number of searches is so much higher than the number of 
   	insertions, the only options whose search complexity is lower than their respective insertion complexity would be 
	options (3) and (4) while options (1) (2) and (5) all have higher insertion complexity and search complexity and 
	therefore are not useful for this application. While options (3) and (4) have the same search complexity option (3) 
	has a faster insertion complexity with O(log n) compared to option (4) where the insertion complexity is O(n), hence 
	why binary search tree would be the best choice for this problem.
          
-------------------------------------------------------------------------------------------------------------------------
Task E.

1) Describe a modification to the BST that will allow it to easily support finding the k-th smallest value
in Θ(logn) average case time. If you find any suggestions, code, algorithms, ideas, etc. from any external resources,
you have to acknowledge any such sources in your .txt file for Homework 02.

Since Binary Search Trees already order the smaller elements of the root on the left side of the tree and order
the larger elements on the right side of the tree, we can rule out searching the right subtree because we know that the
elements with larger values are in that subtree. We can use a helper function that gives the height of the left subtree.
Then, we can set a variable, k, and its value to take in root. After, we can use a while loop to traverse through the left 
subtree constantly comparing and replacing the value k when we find a value less than k. Then
by the end, we'll have the k-th smallest element.

2) Write pseudocode for an implementation of the algorithm you described at Task E part 1. Note: you don't have to provide a 
fully functional Java implementation for this exercise -- providing your answer in Java-like pseudocode format is a sufficient
answer to this question, as long as its logic is correct and the meaning is unequivocal and clear. However, you have to 
provide this functionality in a method named findKthSmallest() that takes one integer (the value k) and returns either the 
node having the k-th smallest value in the entire tree (if found) or none (if not found).

findKthSmallest(Tree k)
	Start at the root
	Set the value of the root to variable k
	For each child in the left subtree
		compare the value of k to the value of each child
		if the value of a child is less than k
			set the value of k to be the lesser value
	return k

// Helper function
int treeHeight(Tree root)
	Start at the root
	if node root equals null,
		return 0.
	Else if the root does not equal null then,
		return the tree Height of the left subtree + 1
