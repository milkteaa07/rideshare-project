PROJECT NAME: Rideshare 
AUTHOR: Ava Teng 
LAST UPDATE: 02/15/24


PROJECT OVERVIEW:
This project contains 4 objects: Road, Station, Car, and Passenger. The goal was to be able to simulate a 
straight, X-mile Road with Stations at every mile. On this Road, there would be a randomly number of Cars and
Passengers with randomly generated starting locations and destinations. Cars will pick up and drop off passengers 
as they go and the program will stop when all cars have reached their destination, regarless of whether all 
Passengers are at theirs. Drivers make $1 per mile per passenger.

Here is the prompt that the RideshareRunner.java program specifically tests for:
Drivers earn $1 for every mile they take a passenger. In one scenario there are 20 cars and 50 passengers. In 
another scenario, there are 10 cars and 40 passengers. Which scenario generally has a higher average revenue per 
car?

RESULTS: 
After running each scenario 250 times, here are the results: 
AVERAGE REVENUE PER CAR FOR SCENARIO I: $15.75
AVERAGE REVENUE PER CAR FOR SCENARIO II: $18.80

Therefore, Scenario II (10 cars, 40 passengers) will generally have a higher average revenue per car. 


CHALLENGES: 
The most challenging part of this project for me was creating the moveR() function in the Road object. It took me 
while to figure out how to loop through everything properly. I wanted to be able to display the Road after each 
step and not give Cars moving forward an advantage over Cars moving backward. In order to do this, I had to find a 
way to loop through everything while also not letting a Car move more than once per round. I ended up adding a flag
to determine whether or not a Car had moved so that when I looped through in a forward direction (i++), the Cars at 
earlier stations moving forward would not be able to move a bunch of times while Cars at the end moving backward 
hadn't moved at all. 
