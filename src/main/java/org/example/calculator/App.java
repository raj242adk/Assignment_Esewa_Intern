package org.example.calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static jdk.jfr.consumer.EventStream.openFile;

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
            saveToFile(num1, num2, operation, result);

        } catch ( CustomeDivideByZeroException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    private static void saveToFile(int num1, int num2, char operation, double result) {

        try (PrintWriter writer = new PrintWriter(new FileWriter("D:/JAva/esewaIntern/simpleCalculator/src/main/resources/calculation.txt2", true))) {
            writer.println("Number 1: " + num1);
            writer.println("Number 2: " + num2);
            writer.println("Operation: " + operation);
            writer.println("Result: " + result);
            writer.println("-----------");
            // The file is automatically closed when exiting the try block

            // Open the file with the default associated application
            openFile(Paths.get("D:/JAva/esewaIntern/simpleCalculator/src/main/resources/calculation.txt"));
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


    private static boolean isValidOperation(char operation) {
        return operation == '+' || operation == '-' || operation == '*' || operation == '/';
    }
}

