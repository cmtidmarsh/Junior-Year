C343 / Summer 2020
lab mini assignment - 06
July 3, 2020 22:47
Clare Tidmarsh, cmtidmar


Task A.

Static Arrays: 
best - O(n)
average O(n)
worst - O(n)

The best, average, and worst cases are all O(n) because while you are traversing though the elements in the array, you are only
replacing the desired index value with another value, in this case null. 
You are deleting the value of the element, but not the element itself. Therefore, the best, worst, and average cases are all
O(n). 

Dynamic:
best - O(n) if the
average - O(n^2)
worst - O(n^2)
The best case is O(n) when the index the last element because if the desired index is the last element, you can just 
iterate through the elements before the last and only remove the last element instead of removing and then 
shifting the other elements. The average and worst cases are the same when the index is any element besides the last because
with any element besides the last element, first you must iterate through and find the element you want to delete(O(n)). 
Then after deleting, you must shift all elements one spot to the left (O(n)). Hence, the time complexity for the program
of the average and worst case being O(n^2).


Task C.

Even though the first removeAt() method is more efficient, it is not desirable to work wit because the program only replaces
the original value of an element with a different value. It does not remove the element, but rather, only removes the value of
that element. Most programs, when using a remove method, want to completely remove the element from the array, not just the
element value. The first removeAt() method can be compared to a replace method because removing one value of an element and
replacing it with another value, null, is exactly want a replace function is. If you wanted to use this program to fully remove
an element, then another method would need to be constructed to extract the element location. Hence, making the program more
inefficient and unsuitable for modern day programming.

However, the first removeAt() method can be a desirable to use in some cases. For instance, in game design, there is usually a
storage-like function where you can carry/store items in the game. The first removeAt() function is useful because when you
take an item out of one of the spaces, you don't necessarily want to completely delete that slot. Instead, you want to have an
empty slot where you can replace the item with another. By using this function, the amount of slots/elements won't change if
you take the item/value out of it because it would just be replacing the item with an empty slot or another item. 
