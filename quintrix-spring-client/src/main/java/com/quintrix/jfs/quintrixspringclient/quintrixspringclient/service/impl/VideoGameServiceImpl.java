package com.quintrix.jfs.quintrixspringclient.quintrixspringclient.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.Model.VideoGame;
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

  // Consuming an api with params
  @Override
  public VideoGame getGameById(String id) {
    Map<String, String> urlParams = new HashMap<>();
    urlParams.put("id", id);
    VideoGame response =
        restTemplate.getForObject(GET_VIDEOGAME_BY_ID_API, VideoGame.class, urlParams);
    return response;
  }

  // posting using resttemplate
  @Override
  public VideoGame createGame(VideoGame videogame) {
    VideoGame response =
        restTemplate.postForObject(CREATE_VIDEOGAME_API, videogame, VideoGame.class);
    return response;
  }

  // updating using Resttemplate ...should be void
  @Override
  public VideoGame updateGame(VideoGame videogame, String id) {
    VideoGame response = getGameById(id);

    response.setMultiPlayer(videogame.getMultiPlayer());
    response.setPc(videogame.getPc());
    response.setPlayStation(videogame.getPlayStation());
    response.setRelease_year(videogame.getRelease_year());
    response.setXbox(videogame.getXbox());
    response.setStudio(videogame.getStudio());
    response.setTitle(videogame.getTitle());

    Map<String, String> param = new HashMap<>();
    param.put("id", id);

    restTemplate.put(UPDATE_VIDEOGAME_API, response, param);
    return response;
  }

  //// deleting using Resttemplate
  @Override
  public void deleteGame(String id) {
    Map<String, String> param = new HashMap<>();
    param.put("id", id);
    restTemplate.delete(DELETE_VIDEOGAME_API, param);
  }



}
