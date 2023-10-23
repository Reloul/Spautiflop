package com.project.jee.spautiflop.vue.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class SongRegistrationBody {

  @NotNull
  @NotBlank
  private String name;

  @NotNull
  @NotBlank
  private String artist;

  private String album;
  private String genre;

  @NotNull
  @NotBlank
  private MultipartFile music;

  private MultipartFile cover;
}
