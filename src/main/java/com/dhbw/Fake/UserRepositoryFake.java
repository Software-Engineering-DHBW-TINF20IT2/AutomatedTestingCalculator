package com.dhbw.Fake;

import lombok.Data;

public class UserRepositoryFake implements UserRepository{
  public User fakeUser;

  public UserRepositoryFake(){
     this.fakeUser = new User(1, "Fred", "ADMIN");
  }

  @Override
  public User getUser(){
    return fakeUser;
  }

  @Override
  public User getUserById(int id) {
    return fakeUser;
  }
}
