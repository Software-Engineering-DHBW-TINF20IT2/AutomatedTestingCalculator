package com.dhbw.Spy;

import java.util.ArrayList;

public class LoggerSpy implements Logger {
  public ArrayList<String> messages = new ArrayList<>();
  @Override
  public void log(String message) {
    // collect messages to inspect instead of logging
    this.messages.add(message);
  }
}
