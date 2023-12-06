package factorial;

public class Factorial {

    public static void main(String[] args) {
        int n = -5;

        System.out.printf("Factorial of %d is %d", n , factorial(n));
    }

    public static int factorial(int n){

        if(n <= 1){
            return n;
        }

        return n * factorial(n -1);
    }
}
