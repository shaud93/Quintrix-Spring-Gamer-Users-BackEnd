package com.quintrix.jfs.quintrixspringclient.quintrixspringclient.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.Model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
