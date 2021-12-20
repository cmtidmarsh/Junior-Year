//C322
//3-4-21
//Lab10: Team 03

//Chris Taddeucci
//Benjamin Bellings
//Jiahui Chang

During our rmi implementation, we updated our model to allow for to hold observer object. 
This is to allow multiple clients or observers to interact with the observable.
We also changed the model interface to implement addObserver().
In the controller, we instantiated the model as an interface and cast in to the remote object.
Structurally, View and Model remain the same.
