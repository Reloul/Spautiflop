package com.project.jee.spautiflop.vue.controller;

import com.project.jee.spautiflop.exception.ArtistAlreadyExistsException;
import com.project.jee.spautiflop.model.Album;
import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.service.AlbumService;
import com.project.jee.spautiflop.service.FileService;
import com.project.jee.spautiflop.vue.model.AlbumDataResponse;
import com.project.jee.spautiflop.vue.model.AlbumRegisterBody;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/album")
public class AlbumController {

  private final AlbumService albumService;
  private final FileService fileService;

  public AlbumController(AlbumService albumService, FileService fileService) {
    this.albumService = albumService;
    this.fileService = fileService;
  }

  @PostMapping(value = "/add", consumes = {"multipart/form-data"})
  public ResponseEntity<Object> GetLoggedUser(@AuthenticationPrincipal LocalUser user, @Valid @RequestBody @ModelAttribute AlbumRegisterBody albumRegistrationBody) {
    try {
      this.albumService.registerAlbum(albumRegistrationBody);
      return ResponseEntity.ok().build();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } catch (IOException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } catch (ArtistAlreadyExistsException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<AlbumDataResponse> GetAlbum(@PathVariable("id") @Valid @RequestBody @ModelAttribute Long id) {
    try {
      return ResponseEntity.ok(new AlbumDataResponse(this.albumService.getAlbum(id)));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
