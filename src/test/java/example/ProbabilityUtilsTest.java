package example;

import org.example.ProbabilityUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityUtilsTest {

    @Test
    void mean() {
        double[] values = {1, 2, 3, 4, 5};
        assertEquals(3, ProbabilityUtils.mean(values));
    }

    @Test
    void variance() {
        double[] values = {1, 2, 3, 4, 5};
//        assertEquals(2.5, ProbabilityUtils.variance(values));
    }

    @Test
    void standardDeviation() {
        double[] values = {1, 2, 3, 4, 5};
//        assertEquals(Math.sqrt(2.5), ProbabilityUtils.standardDeviation(values));
    }

    @Test
    void binomialCoefficient() {
        assertEquals(10, ProbabilityUtils.binomialCoefficient(5, 2));
    }

    @Test
    void binomialProbability() {
        double probability = ProbabilityUtils.binomialProbability(5, 2, 0.5);
        assertEquals(0.3125, probability);
    }
}

