package com.project.jee.spautiflop.vue.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponse {
  private final String jwt;

  public UserLoginResponse(String jwt) {
    this.jwt = jwt;
  }


}
