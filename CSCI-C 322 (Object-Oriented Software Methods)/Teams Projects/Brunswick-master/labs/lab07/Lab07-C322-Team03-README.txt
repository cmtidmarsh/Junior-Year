//C322
//3-4-21
//Lab07: Team 03

//Chris Taddeucci
//Benjamin Bellings
//Jiahui Chang


When observing the application we found that when the bpm was set and the player was stopped, upon restarting the player, 
the bpm was reset to its default (90 bpm) instead of the set bpm.

This bug occurred because each time the on() method was called in the BeatModel class, the bpm would reset to 90. removing this variable fixed the bug. 

We did not find any other bugs in the Program.