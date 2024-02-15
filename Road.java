import java.util.*;
public class Road {

    // fields
    Station[] road;

    // POSSIBLE boolean field isDone to check if all cars are done moving -- possibly create another ArrayList<Car> just for this so no need to loop through Stations
    
    // constructor
    public Road(int ROADLENGTH, int CARS, int PASSENGERS){
        road = new Station[ROADLENGTH];

        // generate cars at random locs and random dests
        for (int i = 0; i<CARS; i++){
            int loc = (int)(Math.random()*ROADLENGTH);
            int dest = (int)(Math.random()*ROADLENGTH);
            Car c = new Car(loc, dest);
            road[loc].getCars().add(c);
        }

        // generate passengers at random loc and random dests
        for (int i = 0; i<PASSENGERS; i++){
            int loc = (int)(Math.random()*ROADLENGTH);
            int dest = (int)(Math.random()*ROADLENGTH);
            Passenger p = new Passenger(loc, dest);
            road[loc].getPassengers().add(p);
        }
    }

    /**
     * match passengers @ station with cars and passengers in car w station
     */
    public void match(){
        // STEP ONE: match passengers @ stations with cars
        for (int k = 0; k<road.length; k++){
            // if there is a car @ the location & not full
            Station s = road[k]; 

            if (s.getCars().size() != 0){
                for (Car c: s.getCars()){
                    // if passenger IN CAR is @ dest, move to station
                    for (Passenger p: c.getPassengers()){
                        if (p.getDest() == k){//if the destination of the passenger matches curr station...
                            s.getPassengers().add(p);
                            c.getPassengers().remove(p);
                        }
                    }
                    // if car has less than 3 passengers, go through passengers at station & match
                    if (c.getPassengers().size() <3){
                        for (int i=0;i<s.getPassengers().size();i++){
                            // if the car is going in the same direction as the person
                            //add the person to the car
                            Passenger p = s.getPassengers().get(i);
                            if (c.getDirection() == p.getDirection()){
                                c.getPassengers().add(p);
                                s.getPassengers().remove(i);
                            }
                        }
                    }
                        
                    }
                }
            }

    }

    // move @ Road level
    public void moveR(){
        // STEP TWO: go through all carsand move everything
        for (Station s: road){
            s.moveS();
        }
        }



    public String toString(){
        String result = "";
        for (Station s: road){
            result += s.toString() +"\n";
        }
        return result;
    }

    }


