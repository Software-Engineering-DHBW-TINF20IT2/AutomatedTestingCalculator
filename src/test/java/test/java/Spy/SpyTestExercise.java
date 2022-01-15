package test.java.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

public class SpyTestExercise {

  @Spy
  List<String> spyList = new ArrayList<String>();

  @Test
  public void whenSpyingOnList_thenCorrect() {
    List<String> list = new ArrayList<String>();
    List<String> spyList = Mockito.spy(list);

    spyList.add("one");
    spyList.add("two");

    Mockito.verify(spyList).add("one");
    Mockito.verify(spyList).add("two");

    assertEquals(2, spyList.size());
  }

  @Test
  public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
    spyList.add("one");
    spyList.add("two");

    Mockito.verify(spyList).add("one");
    Mockito.verify(spyList).add("two");

    assertEquals(2, spyList.size());
  }

  //whenStubASpy_thenStubbed

  @Test
  public void what_type_of_testdouble() {
    List<String> list = new ArrayList<String>();
    List<String> spyList = Mockito.spy(list);

    assertEquals(0, spyList.size());

    Mockito.doReturn(100).when(spyList).size();
    assertEquals(100, spyList.size());
  }

}
