package org.example.calculator;

public class CalculateImpl implements CalculateOperation{
    @Override
    public int performAddition(int a, int b) {
        return a+b;
    }

    @Override
    public int performSubtraction(int a, int b) {
        return a-b;
    }

    @Override
    public int performMultiplication(int a, int b) {
        return a*b;
    }

    @Override
    public double performDivision(int a, int b) throws CustomeDivideByZeroException {
        if (b!=0){
            return (double) a/b;
        }
        else {
            throw new  CustomeDivideByZeroException("Cannot perform division by zero");
        }
    }
}
