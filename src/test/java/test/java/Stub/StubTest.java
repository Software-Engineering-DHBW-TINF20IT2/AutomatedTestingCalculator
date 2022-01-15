package test.java.Stub;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dhbw.Stub.ExampleInterface;
import com.dhbw.Stub.Stub;
import org.junit.jupiter.api.Test;
import com.dhbw.Stub.ExampleStub;

public class StubTest {
  @Test
  public void doSomethingTest() {
    // given
    ExampleInterface exampleObject = new ExampleStub();

    // when
    int var1 = new Stub().doSomething(exampleObject);

    // then
    assertEquals(var1, exampleObject.getVar1());
  }
}
