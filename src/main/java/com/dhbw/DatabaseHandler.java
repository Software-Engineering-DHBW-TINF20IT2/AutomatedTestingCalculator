package com.dhbw;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {

  public boolean writeToDatabase(String message) {
    System.out.println("Write text to database: " + message);
    return true;
  }

  public void createNewDatabase(String fileName) {
    String url = "jdbc:sqlite:C:/sqlite/db/" + fileName;
    try (Connection conn = DriverManager.getConnection(url)) {
      if (conn != null) {
        DatabaseMetaData meta = conn.getMetaData();
        System.out.println("The driver name is " + meta.getDriverName());
        System.out.println("A new database has been created.");
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}