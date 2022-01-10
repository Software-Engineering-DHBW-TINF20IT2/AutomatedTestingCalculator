package com.dhbw;

import java.io.File;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        final String filename = "CalculatorHistory.txt";
        Calculator1 calculator = new Calculator1(new File(filename));

        // add
        BigInteger result = calculator.add(BigInteger.valueOf(3),
            BigInteger.valueOf(2));
        System.out.println("Add two numbers: " + result);
    }

}





/*
// substract
        result = calculator.substract(3,2);
            System.out.println("Substract two numbers: " + result);

            // multiply
            result = calculator.multiply(3,2);
            System.out.println("Multiply two numbers: " + result);

            // divide
            result = calculator.divide(3,2);
            System.out.println("Divide two numbers: " + result);
*/
