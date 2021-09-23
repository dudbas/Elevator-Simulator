/**
 * The <code>Elevator</code> class creates an elevator object
 *
 * @author
 * James Lam
 * 114439394
 * james.lam.2@stonybrook.edu
 * CSE214 Rec1
 * Homework #3
 */
public class Elevator {
    int currentFloor;
    int elevatorState;
    Request request;

    int IDLE;
    int TO_SOURCE;
    int TO_DESTINATION;

    /**
     * Creates an Elevator object
     * PostConditions:
     * Elevator is set to idle, and the current floor is 1. Request is empty so its set to null.
     */
    public Elevator(){
        IDLE=-1;
        TO_SOURCE=0;
        TO_DESTINATION=-2;

        currentFloor=1;
        elevatorState=-1;
        request=null;
    }

    /**
     * Gives the current floor the elevator is on
     * @return
     * Returns the current elevator floor
     */
    public int getCurrentFloor(){
        return currentFloor;
    }

    /**
     * Gives the state of the elevator
     *
     *
     * @return
     * Returns the state of the elevator
     */
    public int getElevatorState(){
        return elevatorState;
    }

    /**
     * Gives the request in the elevator
     * @return
     * The request in the elvator
     */
    public Request getRequest(){
        return request;
    }

    /**
     * Sets the current floor of the elevator
     * @param n
     * The floor the elevator set to
     */
    public void setCurrentFloor(int n){
        currentFloor=n;
    }

    /**
     * Sets the current request in the elevator
     * @param n
     *
     * Request or Passenger of the elevator
     */
    public void setRequest(Request n){
        request=n;
    }

    /**
     * Sets the current elevator state
     * @param n
     *
     * The elevator state
     */
    public void setElevatorState(int n){
        elevatorState=n;
    }
}
