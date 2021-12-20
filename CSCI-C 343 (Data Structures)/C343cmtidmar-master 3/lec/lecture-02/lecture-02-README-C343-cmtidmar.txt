C343 / Summer 2020
Lecture task-02
June 24, 2020 11:50
Clare Tidmarsh, cmtidmar


Could a Random Access Machine be implemented by using a Pointer Machine? If yes, how? If not, why not?

No, you cannot implement a RAM by using a Pointer Machine. Even though we can implement
a Pointer Machine to a RAM, in lecture it was mentioned that a Pointer Machine is
"weaker" than a RAM. Going off that statement alone, if a machine is weaker than another,
then it can only be implemented by first using the stronger system. Logically, you cannot
implement the stronger machine into a weaker one as the weaker machine won't have the
ability or capacity to handle the stronger machine's functions. However, if you implement
the weaker machine into the stronger, then stronger machine would have the ability to
perform the functions of the weaker machine as it can support a less advanced machine.
Hence, you cannot implement a RAM using a Pointer Machine, but you can implement a
Pointer Machine by using a RAM.

Another reason is a RAM, or random access machine, randomly
selects elements, whereas, a pointer machine must perform its actions in the order the 
elements are in. Hence, the RAM is a stronger machine than a Pointer machine since it has
more capability. If you were to implement a Pointer Machine into a RAM, then you would be
able to randomly access all of the elements at separate times. However, if you were to implement a RAM into a Pointer Machine, then you would have to access all of the elements
before the desired element. Hence, another reason why you cannot implement a RAM.by using 
a Pointer Machine. 