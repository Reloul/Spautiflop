package com.project.jee.spautiflop.vue.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ArtistRegisterBody {

  @NotNull
  @NotBlank
  @Size(min = 3, max = 250)
  private String name;

    private MultipartFile cover;
}
