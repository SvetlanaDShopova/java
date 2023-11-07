package sds;

/**
 *  Usage :
 *       Implementing "Undo" operation
 *       Implementing "Back" button in web browser
 *       Holding the memory for recursive calls in a programming language
 *       Translating infix notation for expressions to postfix
 *
 *  Push and Pop have constant time complexity - O(1)
 *  isEmpty, isFull  - O(1)
 *
 *  Space Complexity is O(N)
 * @param <T>
 */
public class Stack<T> {

    private static int MAX_SIZE = 40;

    private Element<T> top;
    private int size = 0;
    public Stack() {
    }

    public void push(T data) throws StackOverflowException{
        if(size == MAX_SIZE) {
          throw new StackOverflowException();
        }

        Element elem = new Element(data, top);
        top = elem;
        size++;
    }

    public T pop() throws StackUnderflowException {
        if(size == 0){
            throw new StackUnderflowException();
        }

        T data = top.getData();
        top = top.getNext();
        size--;

        return data;
    }

    public T peek() throws StackUnderflowException {
        if(size == 0){
            throw new StackUnderflowException();
        }

        return top.getData();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }


    public static class Element<T> {
        private T data;
        private Element next;

        public Element(T data, Element next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    public static class StackOverflowException extends Exception {

    }

    public static class StackUnderflowException extends Exception {

    }
}

