import java.util.*;
public class Road {

    // fields
    Station[] road;

    // POSSIBLE boolean field isDone to check if all cars are done moving -- possibly create another ArrayList<Car> just for this so no need to loop through Stations

    // constructor
    public Road(int ROADLENGTH, int CARS, int PASSENGERS){
        road = new Station[ROADLENGTH];
        for (int i = 0; i<road.length;i++){
            road[i] = new Station();
        }
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
    
    public Road(int length){
        road = new Station[length];
        for (int i = 0; i<road.length;i++){
            road[i] = new Station();
        }
    }

    /**
     * match passengers @ station with cars and passengers in car w station
     */
    public void match(Station[] road){
        // STEP ONE: match passengers @ stations with cars
        for (int r = 0; r<road.length; r++){
            // if there is a car @ the location
            Station s = road[r];
            if (s.getCars().size() != 0){
                for (Car c: s.getCars()){
                    //check passengers in car and move to station if at dest
                    for (int k = 0; k<c.getPassengers().size();k++){
                        System.out.println("CHECKPOINT: "+c.getPassengers().get(k).getLoc() + c.getPassengers().get(k).getDest());
                        if (c.getPassengers().get(k).getLoc() == c.getPassengers().get(k).getDest()){
                            System.out.println("CHECKPOINT: "+c.getPassengers().get(k).getLoc() + c.getPassengers().get(k).getDest());
                            s.getPassengers().add(c.getPassengers().get(k));
                            c.getPassengers().remove(k);
                            System.out.println("TESTING: "+s.toString());
                            k--;
                            
                        }
                    }

                    if (c.getPassengers().size() <3){
                        for (int i=0;i<s.getPassengers().size();i++){
                            // if the car is going in the same direction as the person
                            //add the person to the car
                            Passenger p = s.getPassengers().get(i);
                            if (c.getDirection() == p.getDirection()){
                                c.getPassengers().add(p);
                                s.getPassengers().remove(i);
                                i--;
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
        for (int i=0; i<road.length; i++){ // go through all stations on the road
            for (int k = 0; k < road[i].getCars().size(); k++) { // iterate in reverse order
                Car c = road[i].getCars().get(k); // current car
                c.moveC(); // modify car location
                System.out.println("TEST: " + c.getLoc() + c.getDest());
                road[i].getCars().remove(c); // remove car from old station
                road[c.getLoc() - 1].getCars().add(c); // add car to new station
                match(road);
                System.out.println(this.toString());
            }

        }
        }


    public boolean isDone(){
        for (Station s: road){
            for (Car c: s.getCars()){
                if (c.getLoc() != c.getDest()){
                    return false;
                }
            }
        }
        return true;
    }

    public Station[] getRoad(){
        return road;
    }

    public String toString(){
        String result = "";
        for (int i = 0; i<road.length;i++){
            result += "STATION " + (i+1) + ": ";
            result += road[i].toString() +"\n";
        }
        return result;
    }

    public static void main(String[] args){
        Road r = new Road(5);
        r.getRoad()[1].getPassengers().add(new Passenger(2, 3));
        r.getRoad()[0].getCars().add(new Car(1, 4));
        System.out.println(r);
        r.moveR();
        System.out.println(r);
    }

    }


