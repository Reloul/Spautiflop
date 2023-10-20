package com.project.jee.spautiflop.vue.controller;

import com.project.jee.spautiflop.service.UserService;
import com.project.jee.spautiflop.vue.model.UserRegistrationBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserRegistrationController {

  private final UserService userService;

  public UserRegistrationController(UserService userService)
  {
    this.userService = userService;
  }
  @PostMapping("/register")
  public void registerUser(@RequestBody UserRegistrationBody userRegistrationBody) {
    userService.registerUser(userRegistrationBody);
  }
}
