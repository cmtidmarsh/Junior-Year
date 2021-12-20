C343 / Summer 2020
Lecture Task - 06
July 1st, 2020 14:20
Clare Tidmarsh, cmtidmar



"invert a string using only one stack, and using only these operations:
input: String A, can read 1 character at a time, from the first to the last character in the string,
output: String B, can write 1 character at a time, from the first to the last character in the string,
may use a Stack S with the operations available from the ADT as seen above

Due by 4:30PM on Wednesday, July 01, 2020."


 initialize variable X with input  // Initializes the desired input string
 create an empty stack S           // Creates an empty stack, so we only use one stack as specified
 int i = 0
 for each i in X.length            // the for-loop runs from 0 to the length of the input, incrementing by 1 
      push A[-1] to S              // continuously push the last character to empty stack S, so in the string "dog", first push "g" then "o" lastly "d"
      set initialize Y to S        // setting the stack of reversed characters to variable Y
 return Y                          // return Y
                                  
                    



