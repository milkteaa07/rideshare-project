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
    public void move(){
        loc += direction;
    }

}
