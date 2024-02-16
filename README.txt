PROJECT NAME: Rideshare PROJECT
AUTHOR: Ava Teng 
LAST UPDATED: 02/15/24


PROJECT OVERVIEW:
This project contains 4 objects: Road, Station, Car, and Passenger. The goal was to be able to simulate a 
straight, X-mile Road with Stations at every mile. On this Road, there would be a randomly a number of Cars and
Passengers with randomly generated starting locations and destinations. 


RESULTS: 


CHALLENGES: 
The most challenging part of this project for me was creating the moveR() function in the Road object. It took me 
while to figure out how to loop through everything properly. I wanted to be able to display the Road after each 
step and not give Cars moving forward an advantage over Cars moving backward. In order to do this, I had to find a 
way to loop through everything while also not letting a Car move more than once per round. I ended up adding a flag
to determine whether or not a Car had moved so that when I looped through in a forward direction, the Cars at earlier 
stations moving forward would not be able to move 5 times while Cars at the end moving backward hadn't moved at all. 