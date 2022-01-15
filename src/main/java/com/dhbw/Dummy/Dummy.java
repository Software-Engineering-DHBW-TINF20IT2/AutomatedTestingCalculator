package com.dhbw.Dummy;

import lombok.Data;

@Data
public class Dummy {
  public final String output = "something";
  public String format(ExampleObject dependency)
  {
    // 'dependency' won't interfere in the expected result.
    // something is done here

    // what interests us is
    return this.getOutput();
  }
}

