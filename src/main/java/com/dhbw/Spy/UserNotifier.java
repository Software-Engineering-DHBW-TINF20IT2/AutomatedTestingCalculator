package com.dhbw.Spy;

public class UserNotifier {
  private Logger logger;

  public UserNotifier(Logger logger) {
      this.logger = logger;
  }

  public void registerUser(UserModelInterface user) {
    this.logger.log("Notify User: " + user.getName());
    // do more stuff to register user here...
  }
}
