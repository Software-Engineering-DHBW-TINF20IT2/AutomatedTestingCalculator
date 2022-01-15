package test.java.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dhbw.Spy.LoggerSpy;
import com.dhbw.Spy.User;
import com.dhbw.Spy.UserNotifier;
import org.junit.jupiter.api.Test;

public class SpyTest {
  @Test
  public void logTest() {
    LoggerSpy logger = new LoggerSpy();
    UserNotifier notifier = new UserNotifier(logger);

    User user = new User(1, "Otto");
    notifier.registerUser(user);

    assertEquals("[Notify User: Otto]", logger.messages.toString());
  }
}
