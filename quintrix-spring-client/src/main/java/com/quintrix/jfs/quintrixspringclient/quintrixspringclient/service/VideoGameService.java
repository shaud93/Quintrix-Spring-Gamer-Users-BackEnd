package com.quintrix.jfs.quintrixspringclient.quintrixspringclient.service;

import org.springframework.http.ResponseEntity;

public interface VideoGameService {

  public ResponseEntity<String> getAllVideoGames();
}
