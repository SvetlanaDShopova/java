package sds;

/**
 * Find the minimum Element in a Stack
 * in a constant time - O(1)
 */
public class MinimumElementOfStack {

    public static void main(String[] args) throws
            Stack.StackUnderflowException, Stack.StackOverflowException{
        MinimumStack minimumStack = new MinimumStack();
        minimumStack.push(2);
        minimumStack.push(4);
        minimumStack.push(10);

        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.push(1);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.push(0);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());

        minimumStack.pop();
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.pop();
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.pop();
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
    }

    public static class MinimumStack {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minimumStack = new Stack<>();

        public void push(int data) throws Stack.StackOverflowException,
                Stack.StackUnderflowException{
            int min = data;
            if(!minimumStack.isEmpty()){
                if(min > minimumStack.peek()){
                    min = minimumStack.peek();
                }
            }
            stack.push(data);
            minimumStack.push(min);
        }

        public int pop() throws Stack.StackUnderflowException {
            minimumStack.pop();
            return stack.pop();
        }

        public int getMinimum() throws Stack.StackUnderflowException{
            return minimumStack.peek();
        }
    }
}
