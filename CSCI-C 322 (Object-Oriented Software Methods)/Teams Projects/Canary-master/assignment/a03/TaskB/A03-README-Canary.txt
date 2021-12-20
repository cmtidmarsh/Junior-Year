C322/ Spring-2021
May 2, 2021
Assignment 03
Team 4

Sunil Sakthivel ssakthi@iu.edu
Riley Campbell  riricamp@iu.edu
Zach Wendholt zwendhol@iu.edu

Design Document

When it comes to player interaction with resources, the Model ensures that the player cannot go below the 10th
parameter and that it will display the gathered points on the player's "user screen" The Resources are subtracted when the user/player is standing on top of the resource

When it comes to several players in the same location, the code ensures that this cannot happen by consistently cross-referencing player positions in a Hashmap and checking its locations

For the starting assignment of resources, the administrator user takes in ints for the location of the clusters.
It also takes in the percentage of resources in each cluster and makes a determination of how to distribute appropriate values through the board

UML Changes
