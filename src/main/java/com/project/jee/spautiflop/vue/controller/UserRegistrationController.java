package com.project.jee.spautiflop.vue.controller;

import com.project.jee.spautiflop.exception.UserAlreadyExistsException;
import com.project.jee.spautiflop.service.UserService;
import com.project.jee.spautiflop.vue.model.UserRegistrationBody;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class UserRegistrationController {

  private final UserService userService;

  public UserRegistrationController(UserService userService)
  {
    this.userService = userService;
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
}
