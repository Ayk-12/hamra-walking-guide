# Hamra Walking Guide

### Description
This project implements a simple Hamra walking guide. The program keeps asking the user for the name of the source and destination until valid names are inputted. The name input should match the names of the points found in the map (case sensitive). After valid input is received, **Dijkstra**’s algorithm is applied to find the shortest path. Then, the path is printed along with directions and distances.


### Example
``` 
Enter your current location: LAU Lower
Enter your destination location: Clemanceau Intersection

Start from: LAU Lower (Gate)
Go East to Intersection 1 (Intersection): 280m
Go East to Intersection 2 (Intersection): 200m
Go North to Barbar (Building): 60m
Go North to Starbucks (Buliding): 117m
Go East to Bank of Beirut (Building): 275m
Go East to Hamra Intersection (Intersection): 100m
Go North to Intersection 7 (Intersection): 78m
Go North to Clemanceau Intersection (Intersection): 214m

You have reached your destination.

Total distance: 1km and 324m.
```

### Algorithm
The program uses **Dijkstra**'s algorithm to find the shortest path between the source and the destination. The graph is implemented as an adjacency list to store the edges between the nodes. The main class is *HamraWalkingGuide.java*. This class combines the helper classes, abiding by the Object Oriented Programming principles, such as encapsulation and inheritance.

The program can be adjusted easily to work for any map by changing the *ConnectingPoint*s and the edges in the *Graph* class.
