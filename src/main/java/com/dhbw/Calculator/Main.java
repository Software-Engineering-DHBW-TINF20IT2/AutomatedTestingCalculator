package com.dhbw.Calculator;

import java.io.File;
import java.math.BigInteger;

/**
 * Client class that uses Calculator
 */
public class Main {

    public static void main(String[] args) {
        // create new calculator
        final String filename = "CalculatorHistory.txt";
        Calculator1 calculator = new Calculator1(new File(filename));

        // add two numbers
        BigInteger result = calculator.add(BigInteger.valueOf(3),
            BigInteger.valueOf(2));
        System.out.println("Add two numbers: " + result);
    }

}