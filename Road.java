
public class Road {

    // fields
    private Station[] road;

    // POSSIBLE boolean field isDone to check if all cars are done moving -- possibly create another ArrayList<Car> just for this so no need to loop through Stations

    // constructor
    public Road(int ROADLENGTH, int CARS, int PASSENGERS){
        road = new Station[ROADLENGTH];
        for (int i = 0; i<road.length;i++){
            road[i] = new Station();
        }
        // generate cars at random locs and random dests
        for (int i = 0; i<CARS; i++){
            int loc = (int)(Math.random()*ROADLENGTH +1);
            int dest = (int)(Math.random()*ROADLENGTH +1);
            //int x = (int)(Math.random() * (high - low + 1) + low;
            Car c = new Car(loc, dest);
            road[loc-1].getCars().add(c);
        }

        // generate passengers at random loc and random dests
        for (int i = 0; i<PASSENGERS; i++){
            int loc = (int)(Math.random()*ROADLENGTH +1);
            int dest = (int)(Math.random()*ROADLENGTH +1);
            Passenger p = new Passenger(loc, dest);
            road[loc-1].getPassengers().add(p);
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
    public void match(){

        // match passengers @ stations with cars & vice versa
        for (int r = 0; r<road.length; r++){
            // if there is a car @ the location
            Station s = road[r];
            if (s.getCars().size() != 0){
                for (Car c: s.getCars()){
                    //check passengers in car and move to station if at dest
                    for (int k = 0; k<c.getPassengers().size();k++){
                        if (c.getPassengers().get(k).getLoc() == c.getPassengers().get(k).getDest()){
                            s.getPassengers().add(c.getPassengers().get(k));
                            c.getPassengers().remove(k);
                            k--;
                            
                        }
                    }
                    // if the car is going in the same direction as the person add the person to the car
                    if (c.getPassengers().size() <3){
                        for (int i=0;i<s.getPassengers().size();i++){
                            
                            Passenger p = s.getPassengers().get(i);
                            if (c.getDirection() == p.getDirection() && p.getLoc()!=p.getDest()){
                                c.getPassengers().add(p);
                                s.getPassengers().remove(i);
                                i--;
                            }
                        }
                    }
                    // if car is at destination, let passenger off
                    if (c.getDest() == c.getLoc()){
                        for (int i = 0; i<c.getPassengers().size(); i++){
                            s.getPassengers().add(c.getPassengers().get(i));
                            c.getPassengers().remove(i);
                            i--;
                        }
                    }
                        
                    }
                }
            }
    }

    // move @ Road level
    public void moveR(){
        // go through all cars and move everything
        for (int i=0; i<road.length; i++){ // go through all stations on the road
            for (int k = 0; k < road[i].getCars().size(); k++) { // go through all cars @ each station
                Car c = road[i].getCars().get(k); // current car
                if (!c.getMoved()){
                    c.moveC(); // modify car location
                    road[c.getLoc() - 1].getCars().add(c); // add car to new station
                    road[i].getCars().remove(c); // remove car from old station
                    c.setMoved(true);
                }
            }
            }
            for (Station s: road){
                for (Car c: s.getCars()){
                    c.setMoved(false);
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
    
    public double avgPay(){
        double avg = 0;
        double count = 0;
        for (Station s: road){
            for (Car c: s.getCars()){
                avg += c.getMiles();
                count += 1;
            }
        }
        return avg/count;
    }

    public String toString(){
        String result = "";
        result += "\nNEW ROUND   NEW ROUND   NEW ROUND   NEW ROUND   NEW ROUND   NEW ROUND\n\n\n";
        for (int i = 0; i<road.length;i++){
            result += "STATION " + (i+1) + ": ";
            result += road[i].toString() +"\n";
        }
        return result;
    }


    public static void main(String[] args){
        Road r = new Road(5);
        Car c1 = new Car(2, 3);
        Car c2 = new Car(1, 5);
        Passenger p1 = new Passenger(2, 4);
        r.getRoad()[1].getCars().add(c1);
        r.getRoad()[0].getCars().add(c2);
        r.getRoad()[1].getPassengers().add(p1);

        System.out.println(r.toString());
        while (!r.isDone()){
            r.match();
            System.out.println(r.toString());
            r.moveR();
            System.out.println(r.toString());
        }

        
    }
    }


