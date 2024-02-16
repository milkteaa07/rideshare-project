import java.util.*;
public class Station {
    //fields
    private ArrayList<Passenger> station;
    private ArrayList<Car> cars;

    //constructor
    public Station(){
        station = new ArrayList<Passenger>(); 
        cars = new ArrayList<Car>();
    }


    //getters
    public ArrayList<Car> getCars(){
        return cars;
    }
    public ArrayList<Passenger> getPassengers(){
        return station;
    }

    public String toString(){
        String result = "";
        result += "\n     PASSENGERS: ";
        for (Passenger p: this.getPassengers()){
            result += "\n          " + p.toString();
        }
        result += "\n     CARS: ";
        for (Car c: this.getCars()){
            result += "\n          " + c.toString();
        }
        result += "\n";
        return result;
    }

    public static void main(String[] args){
        Station s = new Station();
        System.out.println(s.toString());
        Car c = new Car(1, 2);
        s.getCars().add(c);
        Passenger p = new Passenger(1, 4);
        c.getPassengers().add(p);
        Passenger p2= new Passenger(3, 4);
        s.getPassengers().add(p2);
        System.out.println(s.toString());
    }

}


