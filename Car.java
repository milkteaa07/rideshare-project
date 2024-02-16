import java.util.*;
public class Car {
    
    //fields
    private int miles;
    private int loc;
    private int dest;
    private int direction; // 1: forward, -1: backward
    private ArrayList<Passenger> passengers;
    private boolean moved;

    //constructor
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
        moved = false;
    }

    //moving function
    public void moveC(){
        //search through all passengers at current station location
        if (loc != dest){
            loc += direction;
            miles +=1;
            for (Passenger p:this.getPassengers()){
                p.setLoc(this.getLoc());
            }
        }
    }
    public void setMoved(boolean b){
        moved = b;
    }

    //getters
    public ArrayList<Passenger> getPassengers(){
        return passengers;
    }

    public int getDirection(){
        return direction;
    }

    public int getMiles(){
        return miles;
    }

    public int getLoc(){
        return loc;
    }
    public int getDest(){
        return dest;
    }
    public boolean getMoved(){
        return moved;
    }

    public String toString(){
        String result = "";
        result += "Car@" + this.hashCode() + " - loc: "+ this.loc+", dest: "+this.dest;
        result += "     {";
        for (Passenger p: this.getPassengers()){
            result += p.toString() + "; ";
        }
        result += "}";
        return result;
    }

    public static void main(String[] args){
        Car c = new Car(1, 4);
        Passenger p = new Passenger(1, 2);
        c.getPassengers().add(p);
        System.out.println(c.toString());
        c.moveC();
        System.out.println(c.toString());
        c.moveC();
        System.out.println(c.toString());
        c.moveC();
        System.out.println(c.toString());
        c.moveC();
        System.out.println(c.toString());
        c.moveC();
        System.out.println(c.toString());

    }

}
