C322 - Lecture25
4/19/21

Riley Campbell - riricampbell@iu.edu
Joshua Levy - jomlevy@iu.edu
Kendall Mangrum - kmangrum@iu.edu


Assigning PlayIDs
- For Assignment02, we solved this by creating a method registerPlayer in the model that
takes in the Controller and since we are using the Observer pattern, we use the observer 
count to serve as PlayerID. 

- We believe it is a good solution, as there shouldn't be any duplicate ids since we are 
not using any pseudo-randomization. 

- We definitely think that the interface should be modified so that the assignment and 
use of playerIDs can be used on both the server and client side more easily. 

- We would modify the RMI interface so that it would include a method that functions in 
the same way as our previously mentioned registerPlayer method. 


Server Side Clock
- Currently our Assignment02 implementation updates the resources every 5 seconds. 

- We would be in favor of the RMI Interface to be modified to provide a server-side 
clock timer for updating resources at a constant pace. This would help ensure that the 
board is consistent across all clients. 



What classes are Client-Side?
- The Model Interface
- View
- Controller
- Pair


What classes are Server-Side?
- The Model


Server side with RMI
- Model


Client side with RMI
- Controller