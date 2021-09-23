/**
 * The <code>OptimalElevator</code> class creates the optimal elevator
 *
 * @author
 * James Lam
 * 114439394
 * james.lam.2@stonybrook.edu
 * CSE214 Rec1
 * Homework #3
 */

import java.util.ArrayList;

public class OptimalElevator extends ArrayList<Request>{
    /**
     * Uses an arraylist of requests, instead of a request
     */
    int currentFloor;
    int elevatorState;
    int direction;
    ArrayList<Request> request;

    int IDLE;
    int TO_SOURCE;
    int TO_DESTINATION;
    public OptimalElevator(){
        IDLE=-1;
        TO_SOURCE=0;
        TO_DESTINATION=-2;
        direction=0;

        currentFloor=1;
        elevatorState=-1;
        request=new ArrayList<Request>();
    }

    public int getCurrentFloor(){
        return currentFloor;
    }
    public int getElevatorState(){
        return elevatorState;
    }
    public ArrayList<Request> getRequest(){
        return request;
    }
    public Request getRequester(int n){
        return request.get(n);
    }
    public int getDirection(){
        return direction;
    }
    public void setCurrentFloor(int n){
        currentFloor=n;
    }
    public void setDirection(int n){
        direction=n;}
    public void setRequest(Request n){
        request.add(n);
    }
    public void setElevatorState(int n){
        elevatorState=n;
    }
}

