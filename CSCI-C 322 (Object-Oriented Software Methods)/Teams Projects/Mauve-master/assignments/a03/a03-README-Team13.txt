C322 / Spring-2021
Assignment02
Team 3
4/18/2021

Tyler Burdon      tcburdon@iu.edu
Jiaqi Huang       jh106@iu.edu
Dylan Herthoge    dherthog@iu.edu

NOTES
=====
The board will fill up in ~5 minutes. The exact time will depent on where the initial 
resources are distributed (and the percentage at each location if the locations are close to 
walls.

To run our game, perfom the following:
- move to ~\DistributedForager\src in each terminal you use
- compile all .java files
- run rmiregistry
- to start the Model, run "java -Djava.security.policy=permit Model"
	- enter the x and y coordinates you would like to distribute resoursces around (within the gameboard)
	- enter the percentage of resources you would like to distribute at the first coordinate pair you entered
		+ i.e. if the first coordiante pair recieves 60%, the second will recieve 40%
	- enter the amount of time you would like the game to last (must be between 5 and 10)
- in separate terminals run "java Controller"


Changes to a02 Design
=====================
- The View now uses the Singleton Pattern in order to fulfill the design requirements


Documentation of Requirements
=============================
* player interaction with resources
   - Players are restricted from entering each other’s cells, therefore every time a 
   player enters a resource, they gain 1 resource level.
   - This is implemented in the gatherResources method of the Model by getting the 
   location of the passed playerID, checking if they are in a cell with resources to 
   collect from, then decreasing that location’s resources by 1 and returning 1 so 
   the client’s score can go up.
* player interaction with other players
   - Players are restricted from entering each other’s cells
   - This is done in the Model with the sendPlayerPosition method.
   - Every time the client calls this method and passes the location they intend to 
   move to, we check if that location already exists in the HashMap of players on the 
   server. If it does, they will not be allowed to move into that location.
* starting assignment of resources
   - For the starting board we chose to have the Admin user or the user who starts 
   the model be the one to set the resources. The way we are doing that is by 
   prompting the user to enter 2 XY coordinates.
                                X0000111000X
								000111111100
								001111111110
								011111111111
								001111111110
								000111111100
								X0000111000X
  The XY coordinate corresponds to the top left X and that is where we start drawing 
  the resources. To change the percentage of resource distribution we decided to prompt 
  the user to enter a percentage for one of the resource circles. From that we 
  calculate the second percentage variable by taking the first variable and subtracting 
  it from 100. Then to calculate the resource value we do 7-(Percentage/100) and cast 
  it to an integer so it rounds the decimal number down. So a 50/50 distribution of 
  resources would be all the resource tiles at the value 3. From that we use a writer 
  to write to a text file full of zeros that represents our board. We then change the 
  value of the board depending on what the XY coordinates are that the Admin gave to us.
* game timer
   - Since we couldn’t add a method to the RMI interface, we had to find a work 
   around. In order to do this, when the server is started it will make the following 
   entry in the players HashMap: -13, new Pair(-length of game-, -time elapsed since 
   start-). This entry is updated with the current elapsed time every time the Model 
   generates new resources (currently once per second). Each View will check if the 
   elapsed time is longer than the length of the game and if it is will display the 
   end screen.
   - When playing the game, the player will see the amount of time the game will run for and 
   the amount of time the game has been running for
   - On the end screen, the player will see their final score
* re-calibrate the growth parameter g
   - The growth parameter was recalibrated based on the tick rate of the server.
   - The server updates every 50 milliseconds and so the growth rate needs to be low 
   enough that the board does not fill immediately.
   - The growth rate we have chosen is 0.025.
   - This is done on the model in the updateResources method.
* Singleton
   - We implemented the singleton pattern as our extra pattern for assignment 3. 
   Instead of using an enum, we used “lazy instantiation” because enums are 
   non-serializable. 
* Observer
   - There is an Observer-Observable relationship between the View and the Controller 
   which is used for recognizing keyboard inputs for player movement
* Simple Factory
   - The simple factory pattern is used to create a new Pair to assist with player 
   positions
* Make changes and use the new RMI interface addition
   - One addition to the existing code we had to make was to add a permission to the 
   permit file in order to have access to write to the text file Input.txt. This was 
   necessary because without it we were getting an error because we couldn’t write to 
   Input.txt. I did not change any implementation or game functionality from the 
   previous team but helped us achieve the new requirement in assignment 3.
   - In order to implement the new gereatePlayerID method, we used a Java.util.Random 
   to generate a random integer. If the generated integer is already used, then it 
   will generate a new integer until it finds a unique one.