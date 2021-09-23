/**
 * The <code>Request</code> class creates a request object.
  * @author
 * James Lam
 * 114439394
 * james.lam.2@stonybrook.edu
 * CSE214 Rec1
 * Homework #3
 *
 */


public class Request {
    int sourceFloor;
    int destinationFloor;
    int timeEntered;

    boolean trust;

    /**
     * Accepts a set amount of floors and creates a request object
     * PostCondition: A random number determined by amount of floors
     * @param floors
     *The amount of floors in the building
     *
     *
     *
     */
    public Request(int floors){
        /**
         * Trust is used in the Optimal simulator to see if the floor has been processed for WaitTime
         */
        trust=true;
        double randSource=Math.random()*floors;
        double randDest=Math.random()*floors;
        if (randSource==0){
            sourceFloor=1;
        }
        else{
            sourceFloor = (int)Math.ceil(randSource);
        }
        if (randDest==0){
            destinationFloor=1;
        }
        else{
            destinationFloor = (int)Math.ceil(randDest);
        }
    }

    /**
     * Sets the source floor
     * @param n
     * floor number
     */
    public void setSourceFloor(int n){
        sourceFloor=n;
    }

    /**
     * Sets destination floor
     * @param n
     * floor number
     */
    public void setDestinationFloor(int n){
        destinationFloor=n;
    }

    /**
     * Sets time entered into elevator
     * @param n
     * Time in units
     */
    public void setTimeEntered(int n){
        timeEntered=n;
    }

    /**
     * Sets trust, see above for trust definition
     * @param b
     * State of trust
     */
    public void setTrust(boolean b){
        trust=b;
    }

    /**
     * Gives amount of source floors
     * @return
     * The source floor
     */
    public int getSourceFloor(){
        return sourceFloor;
    }

    /**
     * Gives the destinationf loor
     * @return
     * The destination floor
     */
    public int getDestinationFloor(){
        return destinationFloor;
    }

    /**
     * Time entered into the elevator
     * @return
     * The time enetered
     */
    public int getTimeEntered(){
        return timeEntered;
    }

    /**
     * The trust state of the elevator
     * @return
     * If the elevator has been processed or not
     */
    public boolean getTrust(){
        return trust;
    }
}
