import java.util.*;
public class Station {
    //fields
    ArrayList<Passenger> station;
    ArrayList<Car> cars;

    //constructor
    public Station(){
        station = new ArrayList<Passenger>(); // how to generate random loc and dest for passengers?
        cars = new ArrayList<Car>();
    }


    //getters
    public ArrayList<Car> getCars(){
        return cars;
    }
    public ArrayList<Passenger> getPassengers(){
        return station;
    }

    // move @ station level
    public void moveS(){
        for (Car c: cars){
            c.moveC();
        }
    }

    public String toString(){
        String result = "";
        result += "STATION " + this+ ":";
        result += "     PASSENGERS: ";
        for (Passenger p: this.getPassengers()){
            result += "          " + p.toString() + "\n";
        }
        result += "\nCARS: ";
        for (Car c: this.getCars()){
            result += "          " + c.toString() + "\n";
        }
        return result;
    }


}


