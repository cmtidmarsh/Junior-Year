Lecture 16 Task README						March 15, 2021
Team 13 Mauve

Team Members
Richard Caraher (rjcarahe@iu.edu)
Nolan Cauley (nmcauley@iu.edu)
Clare Tidmarsh (cmtidmar@iu.edu)

previous project chosen : Duck Adapter

What we were able to accomplish:
- added a DuckInt interface that extends java.rmi.Remote
- added a DuckServer class that extends UnicastRemoteObject and implements DuckInt
- added getDuck method to the DuckInt interface
- added some exception handling in the DuckServer

What may have gone wrong:
- We had some issues creating and optimizing the returns within DuckServer

What changes did we have to make to Duck Adapter for RMI to work:
- No changes