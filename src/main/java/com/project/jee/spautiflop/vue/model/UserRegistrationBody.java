package com.project.jee.spautiflop.vue.model;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UserRegistrationBody {

  @NonNull
  @NotBlank
  @Size(min = 3, max = 250)
  private String pseudo;

  @NonNull
  @NotBlank
    @Pattern(regexp =  "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", message = "Password must contain at least 8 characters, one uppercase letter and one number")
  private String password;

  private MultipartFile photo;

}
