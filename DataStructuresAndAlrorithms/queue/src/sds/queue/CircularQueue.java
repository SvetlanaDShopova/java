package sds.queue;

import java.lang.reflect.Array;

/**
 * Performance and complexity
 *
 * Enqueueing and dequeuing has time complexity of O(1)
 *
 * Space complexity is O(N)
 * @param <T>
 */
public class CircularQueue<T> {
    private static final int SPECIAL_EMPTY_VALUE = -1;
    private static int MAX_SIZE = 40;
    private T[] elements;

    //The head index is initialized to a special value which
    // indicate that the queue is empty
    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    public CircularQueue(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }



    public CircularQueue(Class<T> clazz, int size){
        elements = (T[]) Array.newInstance(clazz,size);
    }

    public T dequeue() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        }

        T data =  elements[headIndex];
        elements[headIndex] = null;
        // This was the last element in the queue
        if(headIndex == tailIndex){
            headIndex = SPECIAL_EMPTY_VALUE;
        } else {
            headIndex = (headIndex + 1) % elements.length;
        }

        return data;
    }

    public void enqueue(T data) throws QueueOverflowException {
        if(isFull()){
            throw new QueueOverflowException();
        }

        tailIndex = (tailIndex + 1) % elements.length;
        elements[tailIndex] = data;

        // This is the first element enqueued, set the head index
        // to the tail index.
        if(headIndex == SPECIAL_EMPTY_VALUE){
            headIndex = tailIndex;
        }
    }

    public boolean offer(T data ){
        if (isFull()){
            return false;
        }

        try {
            enqueue(data);
        } catch (QueueOverflowException qoe){

        }

        return true;
    }

    public T peek() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        }

        return elements[headIndex];
    }

    public boolean isEmpty() {
        return headIndex == SPECIAL_EMPTY_VALUE;
    }

    public boolean isFull() {
        int nextIndex = (tailIndex + 1) % elements.length;

        return nextIndex == headIndex;
    }

    public static class QueueOverflowException extends Exception {

    }

    public static class QueueUnderflowException extends Exception {

    }
}
