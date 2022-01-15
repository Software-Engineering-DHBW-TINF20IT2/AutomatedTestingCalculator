package com.dhbw.Spy;

import lombok.Data;

@Data
public class User implements UserModelInterface {
  public int id;
  public String name;

  public User(int id, String name) {
    this.id = id;
    this.name = name;
  }
}
