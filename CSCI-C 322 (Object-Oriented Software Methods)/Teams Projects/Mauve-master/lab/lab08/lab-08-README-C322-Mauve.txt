Lab 08 Team README (Mauve : Team 13)							March 11, 2021

Team Members:
Richard Caraher (rjcarahe@iu.edu)
Nolan Cauley (nmcauley@iu.edu)
Clare Tidmarsh (cmtidmar@iu.edu)

For lab 08, we had to write an entire program based on a UML diagram made in 25 minutes in the 
previous lecture. As such, given the time crunch of creating the UML, we left a lot of general ideas 
in the document and moreso created the document as a way to show overall flow between interacting 
classes. But as per lab 08's instructions, we must follow the UML diagram exactly, so alas, we tried
our best to. 

Issues found that we not allowed to change without redoing the entire UML and writing a 2 page essay on it.
-draw() method in CellWorld should be paintComponent() so we can draw the world. 
-Need to use actionlistener as a timer to allow the game of life to progress
-public 2d array in CellWorld to hold board spaces and information on each cell in the game of life.
-observer implementation should come through the cell observer and not through the observer interface.

Our solutions to these issues:
- we literally wrote a jComponent method in initilize(), which calls draw and passes the paintComponent.
- modified the update() functionality within liveCell/deadCell to properly address the life state of a cell

Issues that still exist:
- Timer doesnt exist to update the cells so that can do the life thing.

