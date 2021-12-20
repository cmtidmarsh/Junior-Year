Lecture 11 Task								Febrary 24, 2021

Team 13 : Mauve

Team members:
Richard Caraher (rjcarahe@iu.edu)
Nolan Cauley (nmcauley@iu.edu)
Clare Tidmarsh (cmtidmar@iu.edu)




Singleton Pattern :
	Advantage : Provides a unique static instance of a desired interface/functionality
		    that allows you to guarentee reliability of output.
	Disadvantage : Not very flexible, has to fill a single instance and doesn't expand well.
	Different : Can prove difficult to test.

Global variable :
	Advantage : Accessibility within project, having a global variable makes it easy to adjust 
		    throughout a program
	Disadvantage : Prone to data corruption, not a private variable and so is not protected
		       to intrusion
	Different : Not really, its just a variable

Command Pattern :
	Advantage : Has an easily readible, function driven sequence that makes logical sense to 
		    program and understand.
	Disadvantage : Command Pattern has a lot of parts that work together, which can serve to make
		       testing and debugging difficult. 
	Different : Loose coupling design pattern

λ-expression :
	Advantage : Functionality driven coding, so any implementation/functionality needed can be 
		    directly coded in to the program without having to fill a specific pattern. 
	Disadvantage : Can produce spaghetti code/become hard to read
