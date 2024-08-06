package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator calculator;
    
    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void testPowerBaseZeroPowerNegative() {
        assertThrows(ArithmeticException.class, () -> calculator.power(0, -1));
    }

    @Test
    void testPowerBaseZeroPowerZero() {
        assertEquals(1, calculator.power(0, 0));
    }
    
    @Test
    void testPowerBasePositivePowerZero() {
        assertEquals(1, calculator.power(5, 0));
    }

    @Test
    void testPowerBasePositivePowerOne() {
        assertEquals(5, calculator.power(5, 1));
    }

    @Test
    void testPowerBaseNegativePowerZero() {
        assertEquals(1, calculator.power(-5, 0));
    }

    @Test
    void testPowerBaseNegativePowerOne() {
        assertEquals(-5, calculator.power(-5, 1));
    }

    @Test
    void testPowerBasePositivePowerNegative() {
        assertEquals(0.2, calculator.power(5, -1));
    }

    @Test
    void testPowerBaseNegativePowerNegative() {
        assertEquals(-0.2, calculator.power(-5, -1));
    }
}
