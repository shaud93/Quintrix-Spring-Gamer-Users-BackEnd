package com.quintrix.jfs.quintrixspringclient.quintrixspringclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.Model.User;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.repository.UserRepository;

@SpringBootApplication
public class QuintrixSpringClientApplication implements CommandLineRunner {

  @Autowired
  MongoTemplate mongo;

  @Autowired
  UserRepository repo;


  public static void main(String[] args) {
    SpringApplication.run(QuintrixSpringClientApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("---------------" + mongo.getCollectionNames());

    repo.save(new User("1", "Ronald", "Mcdonald", "Mcplayer100"));
  }

}
