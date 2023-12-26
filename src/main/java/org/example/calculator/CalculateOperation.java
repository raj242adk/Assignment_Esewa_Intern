package org.example.calculator;

public interface CalculateOperation {

    int performAddition(int a,int b);
    int performSubtraction(int a,int b);
    int performMultiplication(int a,int b);
    double performDivision(int a,int b) throws CustomeDivideByZeroException;
}
