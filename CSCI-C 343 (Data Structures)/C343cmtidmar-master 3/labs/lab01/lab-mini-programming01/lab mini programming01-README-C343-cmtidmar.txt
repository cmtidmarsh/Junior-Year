C343 / Summer 2020
Lab Mini Programming-01
June 24, 2020 14:54
Clare Tidmarsh, cmtidmar


In addition to the above files, write a single README file, in which you describe (very briefly)
how you organized your IU GitHub repository for C343, according to the above explanations, 
as well what you observed as result of your FlippingPixels.java instance.


Oranization
------------
I organized my IU github in 3 different folders: hw for homework assignments, labs for lab assignments, and lec for lecture
assignments and notes.

Within all of the folders are subfolders for the appropriate assignment. For example in labs, the assignment from lab 1, is
in a folder called, "lab01". Within that subfolder are more folders. Since there are 2 lab01 assignments, there's "lab-mini01"
which is the example "Hello World" first program used in the tutorial. Then there's "lab-mini-programming01" which is the
AEI programming assignment in Java. 

Another example is the lec folder. Within the lec folder, there's a subfolder called, "lecture-01". "Lecture-01" contains a
txt file called "lecture-01-README-C343-cmtidmar.txt", which is the lecture task from lecture 01. 

Flipping Pixels Review
--------------------

While doing the flipping pixels assignment, I knew I could simply write a for loop and have mini ovals go diagonally up, but
I thought there would be an easier way. I'm not sure if using rotate from Graphics2D was allowed, but I did manage to do this
assignment with only using ovals and no other shapes. However, by rotating the oval at an angle of (30 * (pi/180)) you
end up with a diagonal line with a positive slope. In order to get a negative slope you must create an angle with a negative
slope, hence, the other side of the "A". I did find this portion challenging as at first I thought you had to use sin or cos,
which led me no where. But after coming back to it, I figured that using the rotate function could be considered incorrect but
it coul also be considered correct (depending on how it's graded),but also the requirement was filled by only using drawOval
and not drawLine or drawRect.