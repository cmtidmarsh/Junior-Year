Lab 07 Team Mauve (13) Readme 						March 4, 2021

Team Members :
Richard Caraher (rjcarahe@iu.edu)
Nolan Cauley (nmcauley@iu.edu)
Clare Tidmarsh (cmtidmar@iu.edu)

First issue was with a proper adjustment with the << and >> arrows and having
them not update the bpm being played. Simply by adding updateBPM() before the
controller sets the bpm we have the current BPM to adjust from instead of default 90.

We found the problem being that when the program is launched, if a bpm is input
without pressing the set button, the bpm output will displays the typed bpm but
plays the original default bpm of 90. 

We fixed this issue by updating the BPM when the actionListener event is triggered,
this helps us avoid consistently resetting the bpm to the current expected value instead 
of 90. The program will now start at whatever value is in the text field when the start
button is pressed.


