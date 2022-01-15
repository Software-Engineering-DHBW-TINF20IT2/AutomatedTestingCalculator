package com.dhbw.Calculator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Example class Calculator1
 * create to show automated testing
 */
public class Calculator1 {

  // File to log results to
  private File output;
  // Handler to write to database
  DatabaseHandler databaseHandler;

  /**
   * Normal constructor with file
   * @param output
   */
  public Calculator1(File output) {
    this.output = output;
  }

  /**
   * Constructor for testing that allows mocks for dependent objects
   * @param output
   */
  public Calculator1(File output, DatabaseHandler databaseHandler) {
    this.output = output;
    this.databaseHandler = databaseHandler;
  }

  /**
   * Add two numbers
   * @param a
   * @param b
   * @return
   */
  public BigInteger add(BigInteger a, BigInteger b) {
    BigInteger result = BigInteger.valueOf(0);
    try {
      result = a.add(b);
    } catch (ArithmeticException ex) {
      throw new ArithmeticException("Can't add values " + a + " and " + b);
    } catch (NullPointerException ex) {
      throw new NullPointerException("Can't add with null values");
    }
    // new feature 1 write to file
    writeToFile(a, b, result, "+");

    // new feature 2 write to database
    writeToDatabase(a, b, result, "+");
    return result;
  }

  /**
   * Write result to file
   * @param a
   * @param b
   * @param result
   * @param operation
   */
  public void writeToFile(BigInteger a, BigInteger b, BigInteger result, String operation) {
    try {
      // create new, write and close file reader
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.output));
      bufferedWriter.write(a + " " + operation + " " + b + " = " + result);
      bufferedWriter.close();
    } catch (IOException ex) {
      System.out.println("Can't write calculation history to file");
    }

  }

  /**
   * Write result to database
   * @param a
   * @param b
   * @param result
   * @param operation
   * @return
   */
  public boolean writeToDatabase(BigInteger a, BigInteger b, BigInteger result, String operation) {
    try {
      // write to database in case of production otherwise mock
      if (this.databaseHandler == null) this.databaseHandler = new DatabaseHandler();
      databaseHandler.writeToDatabase(a + " " + operation + " " + b + " = " + result);
      return true;
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      return false;
    }
  }


  /**
   * Substract two numbers
   * @param a
   * @param b
   * @return
   */
  public int substract(int a, int b) {
    return a-b;
  }

  /**
   * Divide two numbers
   * @param a
   * @param b
   * @return
   */
  public int divide(int a, int b) {
    return a/b;
  }

  /**
   * Multiply two numbers
   * @param a
   * @param b
   * @return
   */
  public int multiply(int a, int b) {
    return a*b;
  }

}
