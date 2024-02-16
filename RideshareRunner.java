import java.util.*;
public class RideshareRunner {
    public static void main(String[] args){
        System.out.println("\nWELCOME TO THE RIDESHARE SIMULATION");
        System.out.println("\nSCENARIO: ");
        System.out.println("Drivers earn $1 for every mile they take a passenger. ");
        System.out.println("In one scenario there are 20 cars and 50 passengers.");
        System.out.println("In another scenario, there are 10 cars and 40 passengers.");
        System.out.println("Which scenario generally has a higher average revenue per car?\n");

        Scanner input = new Scanner(System.in);
        System.out.println("Would you like the first test of each scenario to be printed step by step? [Y/N]");
        String a = input.next();
        System.out.println("\nCreating and running tests...");
        
        int NUMTESTS = 250;
        double total = 0;
        for (int i = 1; i<=NUMTESTS; i++){
            Road r = new Road(31, 20, 50);
            if (i == 1 && a.equals("Y")){
                while (!r.isDone()){
                    r.match();
                    System.out.println(r.toString());
                    r.moveR();
                    System.out.println(r.toString());
                }
            }else{
                while (!r.isDone()){
                    r.match();
                    r.moveR();
                }
            }
            
            //System.out.println("TEST "+i+" AVERAGE REVENUE PER CAR: $" + String.format("%.2f", r.avgPay()));
            total += r.avgPay();
        }
        //System.out.println("\nAVERAGE FOR SCENARIO I: $"+ String.format("%.2f", total/NUMTESTS)+"\n");

        double total2 = 0;
        for (int i = 1; i<=NUMTESTS; i++){
            Road r = new Road(31, 10, 40);
            if (i == 1 && a.equals("Y")){
                while (!r.isDone()){
                    r.match();
                    System.out.println(r.toString());
                    r.moveR();
                    System.out.println(r.toString());
                }
            }else{
                while (!r.isDone()){
                    r.match();
                    r.moveR();
                }
            }
            
            //System.out.println("TEST "+i+" AVERAGE REVENUE PER CAR: $" + String.format("%.2f", r.avgPay()));
            total2 += r.avgPay();
        }
        //System.out.println("\nAVERAGE FOR SCENARIO II: $"+ String.format("%.2f", total2/NUMTESTS));

        System.out.println("\nAfter running each scenario " + NUMTESTS + " times, here are the results: ");
        System.out.println("AVERAGE FOR SCENARIO I: $"+ String.format("%.2f", total/NUMTESTS));
        System.out.println("AVERAGE FOR SCENARIO II: $"+ String.format("%.2f", total2/NUMTESTS));

        input.close();
    }
}
