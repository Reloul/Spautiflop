package com.project.jee.spautiflop.vue.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class AlbumRegisterBody {

  @NotNull
  @NotBlank
  @Size(min = 3, max = 254)
  private String name;

  @NotNull
  @NotBlank
  @Size(min = 3, max = 254)
  private String artist;

  @Size(max = 4)
  @Pattern(regexp =  "^[0-9]*$", message = "release must only contains letters")
  private String release;

  private MultipartFile cover;
}
