package com.quintrix.jfs.quintrixspringclient.quintrixspringclient.service;

import org.springframework.http.ResponseEntity;
import com.quintrix.jfs.quintrixspringclient.quintrixspringclient.Model.VideoGame;

public interface VideoGameService {

  public ResponseEntity<String> getAllVideoGames();

  public VideoGame getGameById(String id);

  public VideoGame createGame(VideoGame videogame);

  public VideoGame updateGame(VideoGame videogame, String id);

  public void deleteGame(String id);

}
