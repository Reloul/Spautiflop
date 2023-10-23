package com.project.jee.spautiflop.vue.model;

import com.project.jee.spautiflop.model.LocalUser;

public class UserProfile {
  private static final String REFACTORED_PATH  = "../../../static/images/";
  private String pseudo;
  private String photo;

  public UserProfile(LocalUser user) {
    this.pseudo = user.getPseudo();
    String[] split = user.getPhoto().split("/");
    this.photo = REFACTORED_PATH + split[split.length-1];
  }
}
