package factorial;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class FactorialTest {

    @Test
    public void testPositiveNumber(){
        int n = 10;
        int result = Factorial.factorial(n);
        assertTrue( result == 3_628_800);
    }

    @Test
    public void testNegativeNumber(){
        int n = -10;
        int result = Factorial.factorial(n);
        assertTrue( result == -10);
    }
}
