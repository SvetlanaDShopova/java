package sds.queue;

/**
 * Performance  and complexity
 * Time complexity is O(M) where M is the number of operation we perform on the queue
 *
 */

import sds.stack.Stack;

public class TwoStackQueue<T> {

    private Stack<T> forwardStack = new Stack<>();
    private Stack<T> reverseStack = new Stack<>();

    public TwoStackQueue() {
    }

    public void enqueue(T data ) throws CircularQueue.QueueOverflowException {
        if(isFull()){
            throw new CircularQueue.QueueOverflowException();
        }

        try {
            if(forwardStack.isEmpty()){
                while(!reverseStack.isEmpty()){
                    forwardStack.push(reverseStack.pop());
                }
            }
            forwardStack.push(data);
        } catch (Stack.StackUnderflowException  | Stack.StackOverflowException e ) {
            throw new CircularQueue.QueueOverflowException();
        }
    }

    public T dequeue() throws CircularQueue.QueueUnderflowException {
        if(isEmpty()){
            throw new CircularQueue.QueueUnderflowException();
        }

        try {
            if(reverseStack.isEmpty()){
                while(!forwardStack.isEmpty()){
                    reverseStack.push(forwardStack.pop());
                }
            }
            return reverseStack.pop();
        } catch (Stack.StackOverflowException | Stack.StackUnderflowException se) {
            throw new CircularQueue.QueueUnderflowException();
        }
    }

    public boolean isFull(){
        return forwardStack.isFull() || reverseStack.isFull();
    }

    public boolean isEmpty() {
        return forwardStack.isEmpty() && reverseStack.isEmpty();
    }
}
