package service;

public class ForecastCalculator {

    // Recursive method to calculate future value
    public double calculateFutureValue(double principal, double rate, int periods) {
        if (periods == 0) return principal;

        double nextValue = calculateFutureValue(principal, rate, periods - 1);
        return nextValue + (nextValue * rate / 100);
    }

    // Optimized version using formula: A = P(1 + r)^n
    public double calculateFutureValueIterative(double principal, double rate, int periods) {
        return principal * Math.pow(1 + rate / 100, periods);
    }
}
