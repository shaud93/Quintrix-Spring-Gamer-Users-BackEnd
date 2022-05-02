package com.quintrix.jfs.quintrixspringclient.quintrixspringclient.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.Model.User;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.repository.UserRepository;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository repository;



  @Override
  public List<User> getAllUser() {
    List<User> response = repository.findAll();
    return response;
  }

  @Override
  public User getUserById(String id) {
    Optional<User> response = repository.findById(id);
    return response.get();
  }

  @Override
  public User createUser(User user) {
    User response = repository.insert(user);
    return response;
  }

  @Override
  public User updateUser(User user, String id) {
    User response = repository.findById(id).get();
    response.setFirst_name(user.getFirst_name());
    response.setLast_name(user.getLast_name());
    response.setGamer_tag(user.getGamer_tag());
    repository.save(response);
    return response;
  }

  @Override
  public void deleteUser(String id) {
    User response = repository.findById(id).get();
    repository.delete(response);
  }



}
