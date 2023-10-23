package com.project.jee.spautiflop.vue.controller;

import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.service.FileService;
import com.project.jee.spautiflop.service.SongService;
import com.project.jee.spautiflop.vue.model.SongRegistrationBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.PublicKey;

@RestController
@RequestMapping("/api/song")
public class SongController {

  private final SongService songService;
  private final FileService fileService;

  public SongController(SongService songService, FileService fileService) {
    this.songService = songService;
    this.fileService = fileService;
  }
  @PostMapping(value = "/add", consumes = "{multipart/form-data}")
  public ResponseEntity<SongRegistrationBody> addSong(@AuthenticationPrincipal LocalUser user, @RequestBody SongRegistrationBody songRegistrationBody) {
    try {
      this.songService.registerSong(songRegistrationBody);
      return ResponseEntity.ok().build();
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } catch (IOException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

  }
}
