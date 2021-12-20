C343 / Summer 2020
lecture task-01
June 23, 2020 15:09
Clare Tidmarsh, cmtidmar

what kind of data structure would be appropriate, in order to solve this problem efficiently?

For this question, you should use an array as the data structure because assuming you're using
a roster of students in alphabetical order to keep track of how many students are in the class. 
From there, you can go down the array of students to determine who came to class on a specfic day.
You can also use an array for the date/time of lecture as dates are set into a specific order of the calender 
year and cannot be changed, hence, an array would be the best data structure to use. 

approximately how long would it take to obtain a yes/no answer?

In order to obtain a yes/no answer, it would take the time complexity of O(n) because O(n) would go down the
array or students and look at each student, individually, and what days they each logged in to attend class. T

How many steps would it take to obtain a yes/no answer?

Using the question above, it will take O(m*n) steps in order to obtain a yes/no answer. The steps in
numerical value would depend on how many students are in the class. 
In this case, they want us to use "n" for n students (where n is some large number) and "m" for m lectures.
Hence, in order for you to be able to determine how came to class when, you would want to use O(m*n), so the
program scans the two arrays together (which students attended which lectures) and scans each element/student
in the array with if they came to class on what day. 
