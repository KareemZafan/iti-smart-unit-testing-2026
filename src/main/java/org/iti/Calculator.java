package org.iti;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double div(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Dividing by zero");
        }
        return a / b;
    }

    public int mod(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Dividing by zero");
        }
        return a % b;
    }

    public int abs(int a) {
        return (a > 0) ? a : -a;
    }

    public double getSquareRoot(double a) {
        if (a < 0) {
            throw new ArithmeticException("Negative numbers are not allowed");
        }
        return Math.sqrt(a);
    }

}
