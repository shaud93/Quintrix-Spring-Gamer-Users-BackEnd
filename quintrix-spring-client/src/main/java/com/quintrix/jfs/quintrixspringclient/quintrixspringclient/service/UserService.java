package com.quintrix.jfs.quintrixspringclient.quintrixspringclient.service;

import java.util.List;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.Model.User;


public interface UserService {

  List<User> getAllUser();

  User getUserById(String id);

  User createUser(User user);

  User updateUser(User user, String id);

  void deleteUser(String id);


}
