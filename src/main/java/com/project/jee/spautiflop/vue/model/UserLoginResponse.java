package com.project.jee.spautiflop.vue.model;

import lombok.Getter;

@Getter
public class UserLoginResponse {
  private final String jwt;

  public UserLoginResponse(String jwt) {
    this.jwt = jwt;
  }


}
