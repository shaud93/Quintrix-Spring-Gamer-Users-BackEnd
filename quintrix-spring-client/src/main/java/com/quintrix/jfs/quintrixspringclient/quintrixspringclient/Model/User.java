package com.quintrix.jfs.quintrixspringclient.quintrixspringclient.Model;



import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@EntityScan
@Document(collection = "Gamer")
public class User {

  @Id
  private String id;

  @Field(name = "first_name")
  private String first_name;

  @Field(name = "last_name")
  private String last_name;


  @Field(name = "tag")
  private String gamer_tag;

  public User(String id, String first_name, String last_name, String gamer_tag) {
    super();
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.gamer_tag = gamer_tag;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getGamer_tag() {
    return gamer_tag;
  }

  public void setGamer_tag(String gamer_tag) {
    this.gamer_tag = gamer_tag;
  }

}
