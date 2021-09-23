/**
 * The <code>BooleanSource</code> creates a request queue.
 *
 * @author
 * James Lam
 * 114439394
 * james.lam.2@stonybrook.edu
 * CSE214 Rec1
 * Homework #3
 */

public class BooleanSource {
    double probability;

    /**
     * Accepts a set probability
     *
     * Precondition: Probability is between 0.0 and 1.0
     * @param p
     * The probability
     *
     */
    public BooleanSource(double p){
        probability=p;
    }

    /**
     * Generates a request if a Random Number is less than the probability
     * @return
     * True if a request was generated
     */
    public boolean  requestArrived(){
        return (Math.random()<probability);
    }
}
