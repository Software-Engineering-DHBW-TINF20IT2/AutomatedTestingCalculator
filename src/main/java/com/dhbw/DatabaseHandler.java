package com.dhbw;

/**
 * Class that represents a database
 * service class to show testing
 * purposes
 */
public class DatabaseHandler {

  /**
   * Write message to database
   * Act like real database handler
   * but print out message
   * @param message
   * @return
   */
  public boolean writeToDatabase(String message) {
    System.out.println("Write text to database: " + message);
    return true;
  }

}
