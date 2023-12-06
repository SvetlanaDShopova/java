package fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FibonacciTest {

    @Test
    public void test10Series(){
        int numberSeries = 10;
        String series ="";
        String result = "0 1 1 2 3 5 8 13 21 34";

        for(int i = 0; i < numberSeries; i++){
            series = series + FibonacciSeries.fibonacci(i) + " ";
        }

        assertTrue(result.equalsIgnoreCase(series.trim()));
    }
}
