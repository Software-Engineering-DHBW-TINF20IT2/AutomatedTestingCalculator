package test.java.Dummy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dhbw.Dummy.Dummy;
import com.dhbw.Dummy.ExampleObject;
import org.junit.jupiter.api.Test;

public class DummyTest {

  @Test
  public void testDummy(){
    //given
    String expectedValue = "something";
    Dummy dummy = new Dummy();
    // -> use dummy values as the values doesn't matter here
    ExampleObject exampleObject = new ExampleObject(1,"dummy",4.0);

    // when
    String actualValue = dummy.format(exampleObject);

    // then
    assertEquals(actualValue, expectedValue);
  }
}
