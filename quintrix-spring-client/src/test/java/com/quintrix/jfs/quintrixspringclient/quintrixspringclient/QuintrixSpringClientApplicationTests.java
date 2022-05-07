package com.quintrix.jfs.quintrixspringclient.quintrixspringclient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.Model.User;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.repository.UserRepository;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.service.UserService;

@SpringBootTest
class QuintrixSpringClientApplicationTests {
  @Autowired
  UserService userservice;

  @MockBean
  UserRepository repo;

  @Test
  public void getAllUsersTest() {
    User user1 = new User("100", "Tucan", "Sam", "FruitLoops44");
    User user2 = new User("200", "Tony", "The Tiger", "FrostedFlakes88");
    List<User> Test = Arrays.asList(user1, user2);

    when(repo.findAll()).thenReturn(Test);
    assertEquals(2, userservice.getAllUser().size());
  }

  @Test
  public void getUserByIdTest() {
    User user1 = new User("100", "Tucan", "Sam", "FruitLoops44");
    String id = "100";
    when(repo.findById(id)).thenReturn(Optional.of(user1));
    assertEquals(id, userservice.getUserById(id).getId());
  }

  @Test
  public void createUserTest() {
    User user1 = new User("100", "Tucan", "Sam", "FruitLoops44");
    when(repo.insert(user1)).thenReturn(user1);
    assertEquals(user1.getId(), userservice.createUser(user1));
  }

}
