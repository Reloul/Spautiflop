package com.project.jee.spautiflop.vue.controller;

import com.project.jee.spautiflop.exception.ArtistAlreadyExistsException;
import com.project.jee.spautiflop.model.Artist;
import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.service.ArtistService;
import com.project.jee.spautiflop.service.FileService;
import com.project.jee.spautiflop.vue.model.ArtistDataResponse;
import com.project.jee.spautiflop.vue.model.ArtistRegisterBody;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {

  private final ArtistService artistService;
  private final FileService fileService;

  public ArtistController(ArtistService artistService, FileService fileService) {
    this.artistService = artistService;
    this.fileService = fileService;
  }
  @PostMapping(value = "/add", consumes = {"multipart/form-data"})
  public ResponseEntity<?> registerArtist(@AuthenticationPrincipal LocalUser user, @Valid @RequestBody @ModelAttribute ArtistRegisterBody artistRegistrationBody) {
    try {
      this.artistService.registerArtist(artistRegistrationBody);
      return ResponseEntity.ok().build();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } catch (IOException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    } catch (ArtistAlreadyExistsException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ArtistDataResponse> GetArtist(@PathVariable("id") @Valid @RequestBody @ModelAttribute Long id) {
    try {
      return ResponseEntity.ok(new ArtistDataResponse( this.artistService.getArtist(id)));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
  }
}
