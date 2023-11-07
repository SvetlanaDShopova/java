package sds;


import sds.queue.CircularQueue;

public class CircularQueueApp {
    public static void main(String[] args) throws CircularQueue.QueueOverflowException, CircularQueue.QueueUnderflowException {

        CircularQueue<Integer> queue = new CircularQueue<>(Integer.class, 4);

        System.out.println("Queue full?: " + queue.isFull());
        System.out.println("Queue empty?: " + queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Queue full?: " + queue.isFull());
        System.out.println("Queue empty?: " + queue.isEmpty());

        queue.enqueue(4);
        System.out.println("Queue full?: " + queue.isFull());
        System.out.println("Queue empty?: " + queue.isEmpty());

        System.out.println("Queue peek: " + queue.peek());

        int data = queue.dequeue();
        System.out.println("Dequeued element: " + data);

        System.out.println("Peek : " + queue.peek());

        data = queue.dequeue();
        System.out.println("Dequeued element: " + data);
        System.out.println("Peek : " + queue.peek());

        try {
            queue.enqueue(4);
            queue.enqueue(5);
            queue.enqueue(6);
        } catch (CircularQueue.QueueOverflowException soe) {
            System.out.println("Queue is full! No room available.");
        }

        try {
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
        } catch (CircularQueue.QueueUnderflowException sue) {
            System.out.println("Queue is empty! No elements available.");
        }

    }
}
