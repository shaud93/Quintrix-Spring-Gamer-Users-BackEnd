package com.quintrix.jfs.quintrixspringclient.quintrixspringclient.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.Model.User;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.service.UserService;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.service.VideoGameService;

@RestController
@RequestMapping("/user/")
public class UserController {

  // service instance
  @Autowired
  VideoGameService videogameservice;

  @Autowired
  UserService userservice;

  @GetMapping("/allgames")
  public ResponseEntity<String> getAllVideoGames() {

    ResponseEntity<String> response = videogameservice.getAllVideoGames();

    return response;
  }


  @PostMapping("/add")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    return new ResponseEntity<User>(userservice.createUser(user), HttpStatus.CREATED);
  }

  // return all Users
  @GetMapping("/all")
  public List<User> getAllUsers() {
    return userservice.getAllUser();
  }

  // Get User By Id
  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
    return new ResponseEntity<User>(userservice.getUserById(id), HttpStatus.OK);

  }

  // Update User
  @PutMapping("/{id}/update")
  public ResponseEntity<User> updateUser(@RequestBody User User, @PathVariable("id") String id) {
    return new ResponseEntity<User>(userservice.updateUser(User, id), HttpStatus.CREATED);
  }

  // Delete User
  @DeleteMapping("/{id}/delete")
  public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
    userservice.deleteUser(id);
    return new ResponseEntity<String>("User has been deleted successfully", HttpStatus.OK);
  }
}

