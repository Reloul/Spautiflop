package com.project.jee.spautiflop.vue.controller;

import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.Playlist;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.service.FileService;
import com.project.jee.spautiflop.service.SongService;
import com.project.jee.spautiflop.vue.model.PlaylistDataResponse;
import com.project.jee.spautiflop.vue.model.SongDataResponse;
import com.project.jee.spautiflop.vue.model.SongRegistrationBody;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.UnknownServiceException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/song")
public class SongController {

  private final SongService songService;
  private final FileService fileService;

  public SongController(SongService songService, FileService fileService) {
    this.songService = songService;
    this.fileService = fileService;
  }

  @PostMapping(value = "/add", consumes = {"multipart/form-data"})
  public ResponseEntity<Object> GetLoggedUser(@AuthenticationPrincipal LocalUser user, @Valid @RequestBody @ModelAttribute SongRegistrationBody songRegistrationBody) {
    try {
      this.songService.registerSong(songRegistrationBody);
      return ResponseEntity.ok().build();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } catch (IOException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<SongDataResponse> GetSong(@PathVariable("id") @Valid @RequestBody @ModelAttribute Long id) {
    try {
      return ResponseEntity.ok(new SongDataResponse(this.songService.getSong(id)));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @GetMapping("/top/{nb}")
    public ResponseEntity<List<SongDataResponse>> GetTopSongs(@PathVariable("nb") @Valid @RequestBody @ModelAttribute Integer nb) {
        try {
          List<SongDataResponse> response = new ArrayList<SongDataResponse>();

          this.songService.getTopSongs(nb).forEach(song -> {response.add(new SongDataResponse(song));});
          return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/random/{nb}")
  public ResponseEntity<List<SongDataResponse>> GetRandomSongs(@PathVariable("nb") @Valid @RequestBody @ModelAttribute Integer nb) {
    try {
      List<SongDataResponse> response = new ArrayList<SongDataResponse>();

      this.songService.getRandomSongs(nb).forEach(song -> {response.add(new SongDataResponse(song));});
      return ResponseEntity.ok(response);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}