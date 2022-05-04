package com.quintrix.jfs.quintrixspringclient.quintrixspringclient.Model;



public class VideoGame {

 
  private long id;

 
  private String title;

 
  private String studio;

  
  private long release_year;


  private Boolean multiPlayer;


  private Boolean xbox;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getStudio() {
    return studio;
  }

  public void setStudio(String studio) {
    this.studio = studio;
  }

  public long getRelease_year() {
    return release_year;
  }

  public void setRelease_year(long release_year) {
    this.release_year = release_year;
  }

  public Boolean getMultiPlayer() {
    return multiPlayer;
  }

  public void setMultiPlayer(Boolean multiPlayer) {
    this.multiPlayer = multiPlayer;
  }

  public Boolean getXbox() {
    return xbox;
  }

  public void setXbox(Boolean xbox) {
    this.xbox = xbox;
  }

  public Boolean getPlayStation() {
    return playStation;
  }

  public void setPlayStation(Boolean playStation) {
    this.playStation = playStation;
  }

  public Boolean getPc() {
    return pc;
  }

  public void setPc(Boolean pc) {
    this.pc = pc;
  }


  private Boolean playStation;


  private Boolean pc;
}



