package example;

import org.example.MathUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void add() {
        assertEquals(7, MathUtils.add(3, 4));
    }

    @Test
    void subtract() {
        assertEquals(-1, MathUtils.subtract(3, 4));
    }

    @Test
    void multiply() {
        assertEquals(12, MathUtils.multiply(3, 4));
    }

    @Test
    void divide() {
        assertEquals(3, MathUtils.divide(12, 4));
    }

    @Test
    void mod() {
        assertEquals(1, MathUtils.mod(5, 2));
    }

    @Test
    void power() {
        assertEquals(8, MathUtils.power(2, 3));
    }

    @Test
    void gcd() {
        assertEquals(4, MathUtils.gcd(12, 8));
    }

    @Test
    void lcm() {
        assertEquals(24, MathUtils.lcm(12, 8));
    }

    @Test
    void isPrime() {
        assertTrue(MathUtils.isPrime(7));
        assertFalse(MathUtils.isPrime(8));
    }

    @Test
    void factorial() {
        assertEquals(120, MathUtils.factorial(5));
    }

    @Test
    void round() {
        assertEquals(1.23, MathUtils.round(1.2345, 2));
    }
}

