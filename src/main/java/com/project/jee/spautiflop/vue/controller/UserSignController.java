package com.project.jee.spautiflop.vue.controller;

import com.project.jee.spautiflop.exception.UserAlreadyExistsException;
import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.service.FileService;
import com.project.jee.spautiflop.service.UserService;
import com.project.jee.spautiflop.vue.model.UserLoginBody;
import com.project.jee.spautiflop.vue.model.UserLoginResponse;
import com.project.jee.spautiflop.vue.model.UserProfile;
import com.project.jee.spautiflop.vue.model.UserRegistrationBody;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class UserSignController {

  private final UserService userService;
  private final FileService fileService;

  public UserSignController(UserService userService, FileService fileService)
  {
    this.userService = userService;
    this.fileService = fileService;
  }
  @PostMapping(value = "/register", consumes = {"multipart/form-data"})
  public ResponseEntity<Object> registerUser(@Valid @RequestBody @ModelAttribute UserRegistrationBody userRegistrationBody) {
    try {
      this.userService.registerUser(userRegistrationBody);
      return ResponseEntity.ok().build();
    } catch (UserAlreadyExistsException ex) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    } catch (IOException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PostMapping( value = "/login", consumes = {"multipart/form-data"})
  public ResponseEntity<UserLoginResponse> loginUser(@Valid @RequestBody @ModelAttribute UserLoginBody userLoginBody) {
    String jsonWebToken = this.userService.loginUser(userLoginBody);

    if(jsonWebToken == null)
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    else {
      UserLoginResponse userLoginResponse = new UserLoginResponse(jsonWebToken);
      return ResponseEntity.ok(userLoginResponse);
    }
  }


  @GetMapping( "/me")
  public LocalUser GetLoggedUser(@AuthenticationPrincipal LocalUser user) {
    try {
      user.setPhoto(fileService.retreiveImage(user.getPhoto()));
    } catch (IOException e) {
      System.out.println(e.getMessage());
      user.setPhoto(fileService.DEFAULT_IMAGE());
    }
    return user;
  }
}
