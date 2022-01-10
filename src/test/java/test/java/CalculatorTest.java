package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.dhbw.Calculator1;
import com.dhbw.DatabaseHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test Calculator Class
 */
public class CalculatorTest {

  // class under test
  private Calculator1 calculator1;
  // file to write results from testing to
  final String filename = "CalculatorHistoryTest.txt";

  @BeforeEach
  public void setUp() {
    calculator1 = new Calculator1(new File(filename));
  }

  @Test
  @DisplayName("Test Calculator.add given two natural numbers and expect valid result")
  public void add_given_natural_no_expect_result() {
    // given
    BigInteger a = BigInteger.valueOf(3);
    BigInteger b = BigInteger.valueOf(2);

    // when
    BigInteger actualResult = calculator1.add(a, b);

    // then
    assertEquals(BigInteger.valueOf(5), actualResult);
  }

  @Test
  @DisplayName("Test Calculator.add given two big natural numbers and expect valid result")
  public void add_given_big_natural_no_expect_result() {
    // given
    BigInteger a = BigInteger.valueOf(1073741825);
    BigInteger b = BigInteger.valueOf(1073741830);

    // when
    BigInteger actualResult = calculator1.add(a, b);

    // then
    BigInteger expected = new BigInteger("2147483655");
    assertEquals(expected, actualResult);
  }

  @Test
  @DisplayName("Test Calculator.add given two big natural numbers and expect big result")
  public void add_given_big_natural_no_expect_big_result() {
    // given
    BigInteger a = new BigInteger(
        "21474836553452354534234345434242342343243242342342345436456456546546456456456456456546456456456456456233242343243345324243552343223423446223423423434234234234233423423423423432432423423423423423423346234234234234342423432400000000000000000002147483655345235453423434543424234234324324234234234543645645654654645645645645645654645645645645645623324234324334532424355234322342344622342342343423423423423342342342342343243242342342342342342334623423423423434242343240000000000000000000");
    BigInteger b = new BigInteger(
        "1073741836234523242343423456464565465464564565464565464564564565345343543534534535343454356633224132342234234234234234232342343242344234324234234234324234234234234234324323423423445654634646343234234534654363230000000000000000000010737418362345232423434234564645654654645645654645654645645645653453435435345345353434543566332241323422342342342342342323423432423442343242342342343242342342342342343243234234234456546346463432342345346543632300000000000000000000");

    // when
    BigInteger actualResult = calculator1.add(a, b);

    // then
    BigInteger expected = new BigInteger(
        "21474836553452354534235419176078576866485585765798810001921921111111921021921021021111801799999990990768585797599978548375894577457657680457655765777476578468557657657657747666666657657657747746846769679888868880685657666934654363230000000002147483655355972871785779775847668468888969888888880189300291309300291291299099081089990990999080189189656475647756874766697576664665768054765784686665765765766584684684684685586485576576576798888681086855765768780785975540000000000000000000");
    assertEquals(expected, actualResult);

  }

  @Test
  @DisplayName("Test Calculator.add given two negative numbers and expect valid result")
  public void add_given_negative_no_expect_result() {
    // given
    BigInteger a = BigInteger.valueOf(-5);
    BigInteger b = BigInteger.valueOf(-7);

    // when
    BigInteger actualResult = calculator1.add(a, b);

    // then
    assertEquals(BigInteger.valueOf(-12), actualResult);
  }

  @Test
  @DisplayName("Test Calculator.add given two big negative numbers and expect valid result")
  public void add_given_big_negative_no_expect_result() {
    // given
    BigInteger a = BigInteger.valueOf(-1073741825);
    BigInteger b = BigInteger.valueOf(-1073741830);

    // when
    BigInteger actualResult = calculator1.add(a, b);

    // then
    BigInteger expected = new BigInteger("-2147483655");
    assertEquals(expected, actualResult);
  }

  @Test
  @DisplayName("Test Calculator.add given two zero numbers and expect valid result")
  public void add_given_zero_no_expect_result() {
    // given
    BigInteger a = BigInteger.valueOf(0);
    BigInteger b = BigInteger.valueOf(0);

    // when
    BigInteger actualResult = calculator1.add(a, b);

    // then
    BigInteger expected = BigInteger.valueOf(0);
    assertEquals(expected, actualResult);
  }


  @Test
  @DisplayName("Test Calculator.add given two null values and expect Arithmetic exception")
  public void add_given_invalid_no_expect_exception() {
    // given when
    Exception exception = assertThrows(NullPointerException.class, () -> {
      calculator1.add(null, null);
    });

    // then
    String expectedMessage = "Can't add with null values";
    String actualMessage = exception.getMessage();
    assertEquals(expectedMessage, actualMessage);
  }

  @Test
  @DisplayName("writeToFile given valid input and expect same file input")
  public void writeToFile_given_valid_input_expect_correct_file() {
    // given when
    calculator1.writeToFile(BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(5),
        "+");

    // when
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String currentLine = reader.readLine();
      assertEquals(currentLine, "2 + 3 = 5");
    } catch (IOException ex) {
      System.out.println("Cannot find test file");
    }

    // afterwards delete test file
    File testfile = new File(filename);
    if (!testfile.delete()) {
      System.out.println("Failed to delete the test file " + filename);
    }
  }


  @Test
  @DisplayName("writeToDatabase given valid input and expect mock to return true")
  public void writeToDatabase_given_valid_input_expect_no_error() {
    // given
    String expected =
        BigInteger.valueOf(2) + " + " + BigInteger.valueOf(3) + " = " + BigInteger.valueOf(5);
    DatabaseHandler databaseHandler = mock(DatabaseHandler.class);
    when(databaseHandler.writeToDatabase(expected)).thenReturn(true);
    calculator1 = new Calculator1(new File(filename), databaseHandler);

    // when
    boolean success = calculator1.writeToDatabase(BigInteger.valueOf(2), BigInteger.valueOf(3),
        BigInteger.valueOf(5), "+");

    // then
    assertTrue(success);
  }

}