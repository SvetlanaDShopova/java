package fibonacci;

/**
 * Print Fibonacci series
 */
public class FibonacciSeries {

    public static void main(String[] args) {
        int numberSeries = 12;

        for(int i = 0; i < numberSeries; i++){
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int num ){
        if(num == 0){
            return  0;
        }
        else if(num == 1 || num == 2){
            return 1;
        }
        else {
            return  fibonacci(num-1) + fibonacci(num - 2);
        }
    }

}
