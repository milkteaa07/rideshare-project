import java.util.*;
public class Passenger{
   
    // fields
    private int loc;
    private int dest;
    private boolean done;


    // constructor

    // for non-random testing
    public Passenger(int a, int b){
        loc = a;
        dest = b;
        if (loc == dest){
            done = true;
        }else{
            done = false;
        }
    }

    // for random testing
    public Passenger(int size){
        loc = (int)(Math.random()*(size+1));
        dest = (int)(Math.random()*(size+1));
        if (loc == dest){
            done = true;
        }else{
            done = false;
        }
    }

    // change location
    public void setLoc(int num){
        loc = num;
        if (loc == dest){
            done = true;
        }else{
            done = false;
        }
    }




}
