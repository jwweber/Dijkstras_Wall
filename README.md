# Dijkstras_Wall

Dikstra's Wall is an original game I created to gain experience implementing more complicated data structures and algorithms.

Please download and view the video demonstration above.

It displays a grid containing a blue box and a red box. When the game is started, the blue box begins to move toward the red box 
always taking the shortest path possible. It is the job of the player to delay the blue box from reaching the red box as long as possible. 
This is done by building walls. Once a new wall is built, the game recalculates the shortest path around that wall, 
so the blue box begins moving intelligently around the wall blocks. The grid is a graph connected as a grid, and the default edge weights 
between the nodes (representing boxes) is one. When a wall is built, the edge weights connecting to that node are increased to 10,000. 
Thus, if the player completely blocks off the blue box from the red box, the shortest path to the red box necessarily goes through the wall,
so it will break down a wall section. Therefore, the best strategy for the user is to create a maze for the blue box to navigate through. 
Players accumulate points based on the speed of the blue box, and how long they can delay it for. When the blue box reaches the red box, 
the player may record his or her score in the high score list. 

Obviously, the game uses my own implementation of Dijkstras algorithm to calculate shortest paths, but in addition, this project serves as 
a show case for my own implementation of many important data structures and algorithms, not from libraries. These include linked lists, 
binary search trees, binary heaps, graphs, queues, stacks and spanning trees with most of their common functions. 
I encourage you to take a look at the source code to get a better idea about the implementation of this game. 

If you have any questions about this project, please direct them to jwweber@asu.edu.