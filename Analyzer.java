/**
 * The <code>Analyzer</code> class accepts user inputs
 *
 * @author
 * James Lam
 * 114439394
 * james.lam.2@stonybrook.edu
 * CSE214 Rec1
 * Homework #3
 */

import java.util.Scanner;

public class Analyzer {
    /**
     * Accepts user inputs and puts it in simulator
     *
     * @param args
     * Args of main
     *
     * @throws EmptyQueueException
     * Throws error if queue is empty
     * @throws IllegalArgumentException
     * Throws if input is out of range of respected inputs
     */
    public static void main(String[] args) throws EmptyQueueException {
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to e l e v a t o r simulator!");
        System.out.println("Enter the probability");
        double prob= sc.nextDouble();
        if (prob<0.0||prob>1.0){
            throw new IllegalArgumentException("Probability outside the range");
        }
        System.out.println("Enter the number of floors");
        int floors=sc.nextInt();
        if (floors<1){
            throw new IllegalArgumentException("Floors outside of range");
        }
        System.out.println("Enter the number of elevators");
        int elevators=sc.nextInt();
        if(!(elevators>0)){
            throw new IllegalArgumentException("Elevators outside of range");
        }
        System.out.println("Enter length of simulation");
        int len= sc.nextInt();
        if(!(len>0)){
            throw new IllegalArgumentException("Length outside of range");
        }

        Simulator.simulate(prob, floors, elevators, len);

        /*System.out.println("Would you like to try a better simulation?");

         */
        OptimalSimulator.simulate(prob, floors, elevators, len);
    }

}
