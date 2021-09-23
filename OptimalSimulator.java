/**
 * The <code>OptimalSimulator</code> class simulates the optimal elevator event
 *
 * @author
 * James Lam
 * 114439394
 * james.lam.2@stonybrook.edu
 * CSE214 Rec1
 * Homework #3
 */

public class OptimalSimulator {
    public static void simulate(double probability, int floors, int elevator, int t) throws EmptyQueueException {
        BooleanSource boo = new BooleanSource(probability);
        boolean chance = false;
        int requestCount = 0;
        OptimalElevator[] elevate = new OptimalElevator[elevator];
        int waitTime=0;
        RequestQueue queue = new RequestQueue();

        Request temp;

        for (int i = 0; i < elevator; i++) {
            elevate[i] = new OptimalElevator();
        }

        for (int i = 0; i < t; i++) {
            chance = boo.requestArrived();

            if (chance) {
                temp = new Request(floors);
                temp.setTimeEntered(i + 1);
                queue.enqueue(temp);
            }

            if (!queue.isEmpty()) {
                for (int j = 0; j < elevator; j++) {
                    if (elevate[j].getElevatorState() == -1) {
                        temp = queue.dequeue();
                        elevate[j].setRequest(temp);
                        elevate[j].setElevatorState(0);
                        requestCount++;
                    }
                    if (queue.isEmpty()) {
                        break;
                    }
                }
                /**
                 * Tests if the request is within range ex: greater than source floor and less than destination floor
                 */
                if (!queue.isEmpty()) {
                    for (int j = 0; j < queue.size(); j++) {
                        RequestQueue temp1 = new RequestQueue();
                        temp1 = queue;
                        Request temp2 = temp1.dequeue();
                        requestCount++;
                        for (int k = 0; k < elevator; k++) {
                            if (elevate[k].getRequest().size() > 0) {
                                Request re = elevate[k].getRequester(0);
                                if (re.getDestinationFloor() >= temp2.getDestinationFloor() &&
                                        re.getSourceFloor() <= temp2.getSourceFloor()) {
                                    elevate[k].setRequest(temp2);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            /**
             * Cycles through the elevator requests to see if any match the current source or destination floors.
             * If "Trust" is true, and therefore not added to waitlist yet, adds to waitlist
             */
                for (int x = 0; x < elevator; x++) {
                    for (int set = elevate[x].getRequest().size()-1; set >=0; set--) {
                        if(elevate[x].getRequest().size()==0){
                            break;
                        }
                        if(elevate[x].getRequester(set).getSourceFloor() == elevate[x].getCurrentFloor()&&
                                elevate[x].getRequester(set).getTrust()){
                            elevate[x].getRequester(set).setTrust(false);
                            waitTime+=((i+1)-elevate[x].getRequester(set).getTimeEntered());
                        }
                        if (elevate[x].getRequester(set).getDestinationFloor() == elevate[x].getCurrentFloor()) {
                            if(elevate[x].getRequester(set).getTrust()){
                                waitTime+=((i+1)-elevate[x].getRequester(set).getTimeEntered());
                            }
                            elevate[x].getRequest().remove(set);
                        }
                    }

                    if (elevate[x].getElevatorState() == -2&&elevate[x].getRequest().size()>0) {
                        if (elevate[x].getCurrentFloor() < elevate[x].getRequester(0).getDestinationFloor()) {
                            elevate[x].setCurrentFloor(elevate[x].getCurrentFloor() + 1);
                        } else if (elevate[x].getCurrentFloor() > elevate[x].getRequester(0).getDestinationFloor()) {
                            elevate[x].setCurrentFloor(elevate[x].getCurrentFloor() - 1);
                        } else if (elevate[x].getCurrentFloor() == elevate[x].getRequester(0).getDestinationFloor()) {
                            elevate[x].setElevatorState(-1);
                        }
                    }


                        if (elevate[x].getElevatorState() == 0&&elevate[x].getRequest().size()>0) {
                            if (elevate[x].getCurrentFloor() < elevate[x].getRequester(0).getSourceFloor()) {
                                elevate[x].setCurrentFloor(elevate[x].getCurrentFloor() + 1);
                            } else if (elevate[x].getCurrentFloor() > elevate[x].getRequester(0).getSourceFloor()) {
                                elevate[x].setCurrentFloor(elevate[x].getCurrentFloor() - 1);
                            } else if (elevate[x].getCurrentFloor() == elevate[x].getRequester(0).getSourceFloor()) {
                                elevate[x].setElevatorState(-2);
                            }
                        }
                    }
                }
        System.out.println("OPTIMAL Total wait time: " + waitTime);
        System.out.println("OPTIMAL Total requests:" + requestCount);
        double avg= (double) waitTime/requestCount;
        System.out.println("OPTIMAL Average wait time: " + String.format("%.2f",avg));
            }
        }

