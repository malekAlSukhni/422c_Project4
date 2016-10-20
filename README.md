# 422c_Project4
Critter Simulator

Our code is structured with two main classes, the main class and the Critter class. The main class serves as the controller which takes commands and changes the Critter world based on that. Our Critter class consists of all the methods provided, with the addition of the private method resolve conflicts, which is used when Critters fight. 

We used a list to hold our Critters. Whenever a new critter is created they are added to the list. Whenever a critter dies they are removed. We used this data structure because these functions are way to add and remove items from. 

We added a global lists, a list to check if the critters have moved. There are also two boolean global variables. One for fight and one for the babies.
