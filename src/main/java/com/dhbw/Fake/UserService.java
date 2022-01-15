package com.dhbw.Fake;

public class UserService {
  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUser(int id) {
    // some code before getting user...
    return userRepository.getUserById(id);
  }

}
