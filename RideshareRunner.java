import java.util.*;
public class RideshareRunner {

    /**
     * QUESTIONS
     * 
     * 1. How to analyze results? How to test for sure that my program is right? Do you have a tester?
     * 2. How should each round move? Currently every Car moves once per roation but how does it affect passengers getting on/off
     *      For example, what if a Car go to a destination skips a passenger because of the order of movement?
     * 
     */
    public static void main(String[] args){

        System.out.println("\nWELCOME TO THE RIDESHARE SIMULATION");
        System.out.println("\nSCENARIO: ");
        System.out.println("Drivers earn $1 for every mile they take a passenger. ");
        System.out.println("In one scenario there are 20 cars and 50 passengers.");
        System.out.println("In a second scenario, there are 10 cars and 40 passengers.");
        System.out.println("Which scenario generally has a higher average revenue per car?\n");

        Scanner input = new Scanner(System.in);
        System.out.println("Would you like the first test of each scenario to be printed step by step? [Y/N]");
        String a = input.next();
        System.out.println("\nCreating and running tests...");
        
        int NUMTESTS = 250;
        double total = 0;
        System.out.println("\nSCENARIO I: ");
        Road r = new Road(31, 20, 50);
        System.out.println(r.toString());
        for (int i = 1; i<=NUMTESTS; i++){
            
            if (i == 1 && a.toLowerCase().equals("y")){
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
        System.out.println("\nSCENARIO I: ");
        //Road r = new Road(ROADLENGTH, CARS, PASSENGERS);
        Road r2 = new Road(31, 10, 40);
        System.out.println(r2.toString());
        for (int i = 1; i<=NUMTESTS; i++){
            if (i == 1 && a.toLowerCase().equals("y")){
                while (!r2.isDone()){
                    r2.match();
                    System.out.println(r2.toString());
                    r2.moveR();
                    System.out.println(r2.toString());
                }
            }else{
                while (!r2.isDone()){
                    r2.match();
                    r2.moveR();
                }
            }
            total2 += r2.avgPay();
        }

        //System.out.println("\nAVERAGE FOR SCENARIO II: $"+ String.format("%.2f", total2/NUMTESTS));

        System.out.println("\nAfter running each scenario " + NUMTESTS + " times, here are the results: ");
        System.out.println("AVERAGE FOR SCENARIO I: $"+ String.format("%.2f", total/NUMTESTS));
        System.out.println("AVERAGE FOR SCENARIO II: $"+ String.format("%.2f", total2/NUMTESTS));

        input.close();
        
    }
}
