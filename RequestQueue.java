/**
 * The <code>RequestQueue</code> creates a request queue.
 *
 * @author
 * James Lam
 * 114439394
 * james.lam.2@stonybrook.edu
 * CSE214 Rec1
 * Homework #3
 */

import java.util.ArrayList;

public class RequestQueue extends ArrayList<Request>{
    ArrayList<Request> r;

    /**
     * Constructs a RequestQueue as an arraylist
     */
    public RequestQueue(){
        this.r=new ArrayList<Request>();
    }

    /**
     * Dequeues from the queue LIFO
     * @return
     *
     * The object that was removed
     *
     * @throws EmptyQueueException
     *
     * If the queue is dequeued while empty, throws an error
     */
    public Request dequeue() throws EmptyQueueException{
        Request ret=null;
        if(this.isEmpty()){
            throw new EmptyQueueException("Queue is empty");
        }
        else{
            ret=r.get(0);
            r.remove(0);
        }
        return ret;
    }

    /**
     * Adds to the end of queue
     * @param n
     *
     * The Request added
     *
     * @return
     * Returns the Request that was added
     */
    public Request enqueue(Request n){
        r.add(n);
        return n;
    }

    /**
     * The size of the arraylist
     * @return
     * The size of the arraylist
     */

    public int size(){
        return r.size();
    }

    /**
     * If the arraylist is empty or not
     * @return
     * True if arraylist is empty
     */
    public boolean isEmpty(){
        return r.isEmpty();
    }
}
