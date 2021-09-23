/**
 * The <code>EmptyQueueException</code> throws an error if the queue is dequeued when it is empty
 *
 * @author
 * James Lam
 * 114439394
 * james.lam.2@stonybrook.edu
 * CSE214 Rec1
 * Homework #3
 *
 */

public class EmptyQueueException extends Exception {
    /**
     * Creates an error when queue is empty
     *
     * @param message Gives the user a message
     */
    public EmptyQueueException(String message) {
        super(message);
    }
}