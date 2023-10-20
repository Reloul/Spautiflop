package com.project.jee.spautiflop.vue.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UserRegistrationBody {
  private String pseudo;
  private String password;
  //private MultipartFile photo;
  private String image;
}
