package com.quintrix.jfs.quintrixspringclient.quintrixspringclient.service.impl;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.service.VideoGameService;

@Service
public class VideoGameServiceImpl implements VideoGameService {

  @Autowired
  static RestTemplate restTemplate = new RestTemplate();

  private static final String GET_ALL_VIDEOGAME_API = "http://localhost:8080/game/all";
  private static final String GET_VIDEOGAME_BY_ID_API = "http://localhost:8080/game/{id}";
  private static final String CREATE_VIDEOGAME_API = "http://localhost:8080/game/add";
  private static final String UPDATE_VIDEOGAME_API = "http://localhost:8080/game/{id}/update";
  private static final String DELETE_VIDEOGAME_API = "http://localhost:8080/game/{id}/delete";


  @Override
  public ResponseEntity<String> getAllVideoGames() {

    // creates header
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    // handle Entity
    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

    // the template call
    ResponseEntity<String> call =
        restTemplate.exchange(GET_ALL_VIDEOGAME_API, HttpMethod.GET, entity, String.class);
    return call;
  }

}
