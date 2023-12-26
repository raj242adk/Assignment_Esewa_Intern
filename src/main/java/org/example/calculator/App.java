package org.example.calculator;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        char operation;
        do {
            System.out.print("Enter the operation (+, -, *, /): ");
            operation = scanner.next().charAt(0);

            if (isValidOperation(operation)) {
                break;
            } else {
                System.out.println("Invalid operation. Please enter a valid operator.");
            }
        } while (true);

        CalculateImpl calculator = new CalculateImpl();
        try {
            double result = 0;
            switch (operation) {
                case '+':
                    result = calculator.performAddition(num1, num2);
                    System.out.println("Result of addition: " + result);
                    break;
                case '-':
                    result = calculator.performSubtraction(num1, num2);
                    System.out.println("Result of subtraction: " + result);
                    break;
                case '*':
                    result = calculator.performMultiplication(num1, num2);
                    System.out.println("Result of multiplication: " + result);
                    break;
                case '/':
                    result = calculator.performDivision(num1, num2);
                    System.out.println("Result of division: " + result);
                    break;
                default:
                    System.out.println("Invalid operation.");
            }
        } catch ( CustomeDivideByZeroException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
    private static boolean isValidOperation(char operation) {
        return operation == '+' || operation == '-' || operation == '*' || operation == '/';
    }
}

