**Hiking Expedition**<br>
In this project is to implement a program that uses a binary search tree to model a mountain hiking expedition: A hiker starts at the top of the mountain. 
They need to find their way down the mountain with limited resources to survive and overcome obstacles. The program will produce a list of all the possible 
paths that the hiker should take to survive.<br>
Nodes in this tree represent a rest-stops. The hiker restocks their supplies at those rest-stops. But they may also encounter obstacles at the rest-stops. 
Some of the supplies that they carry with them may help them pass through the obstacles. The paths from the root down represent possible trails. One the hiker 
starts a single path, they do not have an option of going back. Some of the paths lead to cliffs, others leads to the bottom of the mountain. 
The 3 possible supplies are food, raft, and axe and the two obstacles are river and fallen tree. An axe is needed to get past a fallen tree, a raft is needed to
get past a river, and one food is needed to get past a reststop. <br>
BSTMountainAdventure Class:This is the class that is the program. This means it has the main method. This class is responsible for parsing and validating the 
command line arguments, reading and parsing the input file, producing any error messages, handling any exceptions thrown by other classes, and producing output. The
command line argument must be a the name of an input text file in which each line represents a single node. The format of each line should be label supplies obstacles
where label is the name of a reststop node, supplies is a list of strings that describe valid supplies at the reststop, and obstacles is a list of string describing
the obstacles at the reststop. Any invalid strings should be ignored.<br>
BSTMountain Class: represents the implementation of the mountain as a binary search tree with reststop nodes.<br>
RestStop class: represents a single reststop meaning it stores the label, supplies, and obstacles at the reststop. <br>
Hiker Class: This class should represent a hiker traveling down the mountain. An object of this class should be capable of keeping track of all the supplies 
that the hiker has in their possession and any other actions the hiker must do to go down the mountain. <br>
Side Note: A valid solution is when the hiker starts from the root and and takes a path that goes down to a node at the highest level(lowest depth) of the binary
search tree. So if it just reaches a leaf node this isn't a valid answer since this represents a cliff not a node at the highest level(bottom of the mountain. 
All valid answers should be printed. <br>
