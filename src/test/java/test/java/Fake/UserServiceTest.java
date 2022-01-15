package test.java.Fake;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dhbw.Fake.User;
import com.dhbw.Fake.UserRepository;
import com.dhbw.Fake.UserRepositoryFake;
import com.dhbw.Fake.UserService;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
  @Test
  public void getUserTest(){
    //given
    UserRepository fakeRepository = new UserRepositoryFake();
    UserService userService = new UserService(fakeRepository);

    // when
    User actualUser = userService.getUser(1);

    // then
    assertEquals(fakeRepository.getUser(), actualUser);
  }
}
