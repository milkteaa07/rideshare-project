
public class Passenger{
   
    // fields
    private int loc;
    private int dest;
    private int direction; // 1: forward, -1: backward


    // constructor

    // for non-random testing
    public Passenger(int a, int b){
        loc = a;
        dest = b;
        if (loc<dest){
            direction = 1;
        }else if (loc>dest){
            direction = -1;
        } 
    }

    // for random testing
    public Passenger(int size){
        loc = (int)(Math.random()*(size+1));
        dest = (int)(Math.random()*(size+1));
    }

    // change location
    public void setLoc(int num){
        loc = num;
    }

    //getters
    public int getDirection(){
        return direction;
    }

    public int getDest(){
        return dest;
    }
    public int getLoc(){
        return loc;
    }

    public String toString(){
        return "Passenger@" + this.hashCode() + " - loc: "+ this.loc + ", dest: " + this.dest;
    }

    public static void main(String[] args){
        Passenger p = new Passenger(1, 2);
        System.out.println(p);
    }

}
