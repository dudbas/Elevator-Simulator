/**
 * The <code>Simulator</code> class simulates an event
 *
 * @author
 * James Lam
 * 114439394
 * james.lam.2@stonybrook.edu
 * CSE214 Rec1
 * Homework #3
 */

public class Simulator {
    /**
     * Simulates the event
     *
     * @param probability
     * Probability of starting an event
     *
     * PreCondition: Number is between 0.0 and 1.0
     * @param floors
     * Amount of floors in the simulation
     * Precondition: Number is greater than or equal to 1
     *
     * @param elevator
     * Amount of floors in the simulation
     * Precondition: Number is greater than or equal to 1
     *
     * @param t
     * The amount of times simulated
     * @throws EmptyQueueException
     * If queue is dequeued while queue is empty, error is thrown
     */
    public static void simulate(double probability, int floors, int elevator, int t) throws EmptyQueueException {
        int waitTime=0;
        BooleanSource boo= new BooleanSource(probability);
        boolean chance= false;
        int requestCount=0;
        Elevator[] elevate= new Elevator[elevator];
        RequestQueue queue= new RequestQueue();
        Request temp;
        for (int i=0; i<elevator; i++){
            elevate[i]= new Elevator();
        }
        /**
         * Generates a new request
         */
        for (int i=0; i<t; i++){
            chance= boo.requestArrived();

            if (chance){
                temp = new Request(floors);
                temp.setTimeEntered(i+1);
                queue.enqueue(temp);
            }

            if(!queue.isEmpty()){
                for (int j=0; j<elevator; j++){
                    if (elevate[j].getElevatorState()==-1){
                        elevate[j].setRequest(queue.dequeue());
                        elevate[j].setElevatorState(0);
                        requestCount++;
                    }
                    if (queue.isEmpty()){
                        break;
                    }
                }

                /**
                 * If elevator state is to destination, then move up if lower or down if higher, and set to idle if reached
                 */
                for(int x=0; x<elevator; x++) {
                    if (elevate[x].getElevatorState() == -2) {
                        if (elevate[x].getCurrentFloor() < elevate[x].getRequest().getDestinationFloor()) {
                            elevate[x].setCurrentFloor(elevate[x].getCurrentFloor() + 1);
                        } else if (elevate[x].getCurrentFloor() > elevate[x].getRequest().getDestinationFloor()) {
                            elevate[x].setCurrentFloor(elevate[x].getCurrentFloor() - 1);
                        } else if (elevate[x].getCurrentFloor() == elevate[x].getRequest().getDestinationFloor()) {
                            elevate[x].setElevatorState(-1);
                        }
                    }

                    /**
                     * If elevator state is to source, move up if lower or down if higher, and set to destination if reached source.
                     * Also add enter time of the request, and the current time.
                     */
                    if (elevate[x].getElevatorState() == 0) {
                        if (elevate[x].getCurrentFloor() < elevate[x].getRequest().getSourceFloor()) {
                            elevate[x].setCurrentFloor(elevate[x].getCurrentFloor() + 1);
                        } else if (elevate[x].getCurrentFloor() > elevate[x].getRequest().getSourceFloor()) {
                            elevate[x].setCurrentFloor(elevate[x].getCurrentFloor() - 1);
                        } else if (elevate[x].getCurrentFloor() == elevate[x].getRequest().getSourceFloor()) {
                            elevate[x].setElevatorState(-2);
                            waitTime+=((i+1)-elevate[x].getRequest().getTimeEntered());
                        }
                    }
                }


            }

        }

        System.out.println("Total wait time: " + waitTime);
        System.out.println("Total requests:" + requestCount);
        double avg= (double) waitTime/requestCount;
        System.out.println("Average wait time: " + String.format("%.2f",avg));
    }

}
