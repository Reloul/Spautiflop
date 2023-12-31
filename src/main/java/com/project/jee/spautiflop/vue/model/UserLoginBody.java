package com.project.jee.spautiflop.vue.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserLoginBody {

  @NotNull
  @NotBlank
  private String pseudo;

  @NotNull
  @NotBlank
  private String password;

}
