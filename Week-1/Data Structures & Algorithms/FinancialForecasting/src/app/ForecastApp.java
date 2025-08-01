package app;

import service.ForecastCalculator;
import java.util.Scanner;

public class ForecastApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ForecastCalculator calculator = new ForecastCalculator();

        System.out.print("Enter starting amount (₹): ");
        double principal = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter growth rate (%): ");
        double rate = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter number of periods (years): ");
        int periods = Integer.parseInt(scanner.nextLine());

        double recursiveResult = calculator.calculateFutureValue(principal, rate, periods);
        double optimizedResult = calculator.calculateFutureValueIterative(principal, rate, periods);

        System.out.printf("\n📈 Forecasted Value (Recursive): ₹%.2f\n", recursiveResult);
        System.out.printf("⚡ Forecasted Value (Optimized): ₹%.2f\n", optimizedResult);

        scanner.close();
    }
}
