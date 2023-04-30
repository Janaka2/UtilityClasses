package org.example;

public class ProbabilityUtils {

    public static double mean(double[] values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }

    public static double variance(double[] values) {
        double mean = mean(values);
        double sumOfSquares = 0;
        for (double value : values) {
            sumOfSquares += Math.pow(value - mean, 2);
        }
        return sumOfSquares / values.length;
    }

    public static double standardDeviation(double[] values) {
        return Math.sqrt(variance(values));
    }

    public static double binomialCoefficient(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }
        double result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - k + i) / i;
        }
        return result;
    }

    public static double binomialProbability(int n, int k, double p) {
        double q = 1 - p;
        return binomialCoefficient(n, k) * Math.pow(p, k) * Math.pow(q, n - k);
    }
}

