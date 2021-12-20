C343 / Summer 2020
Presentation - 02
July 7, 2020 21:18
Clare Tidmarsh, cmtidmar

Question 7 Received:
Using one of the List ADT (written in Java) as seen at Lecture 05, write a Java function to interchange the current element
and the one following it. Be precise: your answer will be evaluated both on the correct use of the List ADT, as well as on
correct Java syntax.
(note: we're not considering a Java Collection type here: we're only considering one of the possible List ADTs as seen
at Lecture 05)

Answer in text form:

In order to interchange the current element and the one following it, you would use an array-based list 
because in an array-based list you can use a Random Access Machine and directly index to the an element, 
making that be the current element, whereas, when using a linked list, you must use a pointer machine, 
so you have to iterate through each element one-by-one. So using a linked list kind of defeats the purpose of 
the current element portion of the function unless the current element is the first element.
Using the list interface that was introduce in lecture05,


Public void swap(int index){
	mvToPos(index); // to move to the desired index
	int a = list.get(); // to get the value of the the index
	list.gonext(); // to move to the next element
	int b = list.get(); // to get value the next element 
	list.set(a); // then I used the set function to intake "a" at b's position
	list.goPre(); // after, I used goPre() for the previous position
	list.set(b); // then used the set function to intake "b" at a's old position
  
  So in the end, the two elements should be interchanged.
