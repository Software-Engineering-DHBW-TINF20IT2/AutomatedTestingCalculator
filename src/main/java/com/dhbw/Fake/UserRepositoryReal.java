package com.dhbw.Fake;

public class UserRepositoryReal implements UserRepository {
  private User user;

  @Override
  public User getUserById(int id) {
    // get user from database
    // code to return real user object
    User realUser = new User(2, "Robert", "GUEST");
    return realUser;
  }

  @Override
  public User getUser() {
    return user;
  }
}
