import java.util.*;
public class Car {
    
    //fields
    private int miles;
    private int loc;
    private int dest;
    private int direction; // 1: forward, -1: backward
    private ArrayList<Passenger> passengers;

    //constructor

    //non-random testing
    public Car(int a, int b){
        miles = 0;
        loc = a;
        dest = b;
        if (loc<dest){
            direction = 1;
        }else if (loc>dest){
            direction = -1;
        }
        passengers = new ArrayList<Passenger>();
    }

    //moving function
    public void moveC(){
        //search through all passengers at current station location
        if (loc != dest){
            loc += direction;
            miles +=1;
            for (Passenger p:this.getPassengers()){
                p.setLoc(p.getLoc()+direction);
            }
        }
    }

    //getters
    public ArrayList<Passenger> getPassengers(){
        return passengers;
    }

    public int getDirection(){
        return direction;
    }

    public String toString(){
        String result = "";
        result += "Car" + this+ " - loc: "+ loc+", dest: "+dest;
        for (Passenger p: this.getPassengers()){
            result += "     " + p.toString() + "\n";
        }
        return result;
    }

    public static void main(String[] args){
        Car c = new Car(1, 4);
        
    }

}
