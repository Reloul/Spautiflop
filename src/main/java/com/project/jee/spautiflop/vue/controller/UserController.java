package com.project.jee.spautiflop.vue.controller;

import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService)
  {
    this.userService = userService;
  }

/*
  @PutMapping("/like/{id}")
  public ResponseEntity<?> likeSong(@AuthenticationPrincipal LocalUser user, @PathVariable("id") @Valid @RequestBody @ModelAttribute Long id)
  {
    try {
     // this.userService.addSongToFav(user, id);
      return ResponseEntity.ok().build();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @PutMapping("/dislike/{id}")
  public ResponseEntity<?> dislikeSong(@AuthenticationPrincipal LocalUser user, @PathVariable("id") @Valid @RequestBody @ModelAttribute Long id)
  {
    try {
    //        this.userService.removeSongFromFav(user, id);
      return ResponseEntity.ok().build();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }*/
}
