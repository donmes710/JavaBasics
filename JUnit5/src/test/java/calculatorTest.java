import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void addsTwoNumbers() {
        calculator calc = new calculator();
        int result = calc.add(2, 3);
        assertEquals(5, result); // check whether result = 5
    }

    @Test
    void divideByZeroThrowsException() {
        calculator calc = new calculator();
        assertThrows(IllegalArgumentException.class, () -> calc.divide(10, 0));
    }
}