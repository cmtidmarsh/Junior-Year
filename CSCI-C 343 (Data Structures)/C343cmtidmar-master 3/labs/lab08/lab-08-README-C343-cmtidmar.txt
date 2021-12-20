Task A.

Assume you work on a file with a collection of very biased DNA sequences--there are a lot more As and Ts than Cs and Gs in the
sequences (A: 50%, T: 35%, C: 10% and G: 5%). Assume that a Huffman coding is used to compress the file: a Huffman code tree
will be built for the given distribution of A, T, C and G, and the Huffman codes will be used to encode the DNA sequences.
What is the compression ratio you can achieve (compresion ratio = uncompressed-size/compressed-size)?
Explain your calculation briefly, showing the encoding table that you obtain from a Huffman Coding Tree.
Hint: fixed-length codes of 2 bits are sufficient for encoding four letters; you need to use this information to calculate the
uncompressed size.

After creating the table and necessary calculations, the compression ratio of A, T, C, and G when A: 50%, T: 35%, C: 10% and G: 5% is approximately 1.21.


Using the probabilities in order from least likely to occur to most likely to occur, the table shows follows:

Step 1
------
A: 50%  = 0.5
T: 35%  = 0.35
C: 10%  = 0.10
G: 5%   = 0.05

Step 2
------
A: 50%  = 0.5
T: 35%  = 0.35
C: 10%  = 0.10  -->
                    0.10+0.05 = .15
G: 5%   = 0.05  -->

Step 3
-----
A: 50%  = 0.5                    0.5                   0.5

T: 35%  = 0.35                   0.35 -->
C: 10%  = 0.10  -->                        0.35+.015 = 0.5
                     0.10+0.05 = 0.15 -->
G: 5%   = 0.05  -->

      | Probability | Huffman Code
---------------------------------
A     |   0.5       |   0
T     |   0.35      |   10
C     |   0.10      |   110
G     |   0.05      |   111

I did the work on paper, then transcribed everything onto the .txt file. Here we can see that in Step 1, I converted all of
of the percentage probabilties into decimal form as it is easier to work with. I didn't have to rearrange the probabilities in
order from least likely to most likely as they were given already sorted. In Step 2, I took the two smallest probabilities, 
added them together. After getting the sum of the two smallest probabilities, I moved the remaining probabilities above
the summed value. Then I repeated the process with 0.15 and 0.35. In the end, I had the probabilities for greatest value and
the summed values.  Step 3 is a visual representation of what the final graph should look like. We can see that there ended
up being a total of 3 "levels", where 3 is the compressed length. The table directly above shows the compressed ASCII using
Huffman Code. So now we can calculate our compressed size,

                        Compressed size = 0.5(1) + 0.35(2) + 0.10(3) + 0.05(3) = 1.65

We know from the problem that the fixed-length codes of 2 bits for the uncompressed size, and we are also given the 
compression ratio formula,

                       Compresion ratio = uncompressed-size/compressed-size
                       
Now,

                       Compresion ratio = uncompressed-size/compressed-size
                                        = 2 / 1.65
                                        = ~1.21
                                        
                                        
Hence, the compression ratio is ~1.21 when the calculated compressed size is 1.65 bits and the uncompressed size is 2 bits.

---------------------------------------------------------------------------------------------------------------------------
Task B.

1) buildCodeTable() - Java implementation in HuffTree.java

The Java method that builds the Huffman Tree is already there: follow what happens to the root variable, and write down 
your explanation about how the Huffman Tree is built in the provided HuffTree.java class, in your plain-text README file.

The Huffman Tree takes in a string of letters, and the weights of the letters as an integer from an arraylist that is stored
in the MinHeap class. Within the HuffTree class, there is a buildTree() function which builds the tree using the arraylist that
is given in the MinHeap class and BinNode class. While the arraylist from MinHeap is greater than 1 element, nodes are referenced
and revised using the removeMin from MinHeap, then a new node is created using the revision. The revised nodes in the buildTree()
function are compressed versions of the original nodes from BinNode. Now, you have your new nodes and need to build a tree to
reflect the new nodes (setting the left node, right node, etc.). Outside of the while loop, the arraylist from MinHeap uses the
removeMin() function on the arraylist and sets that value to be the root. The new root weight is the value of the arraylist
.removemin() function.

2) decode() - Java implementation in HuffTree.java
                                         
                                         
