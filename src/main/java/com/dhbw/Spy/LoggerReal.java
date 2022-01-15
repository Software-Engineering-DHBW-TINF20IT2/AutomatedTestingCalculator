package com.dhbw.Spy;

public class LoggerReal implements Logger {
  @Override
  public void log(String message) {
    // write to log (example just use console)
    System.out.println(message);
  }
}
