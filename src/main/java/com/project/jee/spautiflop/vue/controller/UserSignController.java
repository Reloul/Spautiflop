package com.project.jee.spautiflop.vue.controller;

import com.project.jee.spautiflop.exception.UserAlreadyExistsException;
import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.Playlist;
import com.project.jee.spautiflop.model.links.Likes;
import com.project.jee.spautiflop.model.repo.LikesRepository;
import com.project.jee.spautiflop.model.repo.PlaylistRepository;
import com.project.jee.spautiflop.service.FileService;
import com.project.jee.spautiflop.service.UserService;
import com.project.jee.spautiflop.vue.model.UserDataResponse;
import com.project.jee.spautiflop.vue.model.UserLoginBody;
import com.project.jee.spautiflop.vue.model.UserLoginResponse;
import com.project.jee.spautiflop.vue.model.UserRegistrationBody;
import jakarta.validation.Valid;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserSignController {

  private final UserService userService;
  private final FileService fileService;
  private final LikesRepository likesRepository;
  private final PlaylistRepository playlistsRepository;

  public UserSignController(UserService userService, FileService fileService, LikesRepository likesRepository, PlaylistRepository playlistsRepository)
  {
    this.userService = userService;
    this.fileService = fileService;
    this.likesRepository = likesRepository;
    this.playlistsRepository = playlistsRepository;
  }
  @PostMapping(value = "/register", consumes = {"multipart/form-data"})
  public ResponseEntity<?> registerUser(@Valid @RequestBody @ModelAttribute UserRegistrationBody userRegistrationBody) {
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


  @GetMapping( value = "/me")
  public UserDataResponse GetLoggedUser(@AuthenticationPrincipal LocalUser user) {

    UserDataResponse userDataResponse = new UserDataResponse(user);

    List<Pair<Long, Pair<String,String>>> playlists = new ArrayList<Pair<Long, Pair<String,String>>>();
    for(Playlist p : playlistsRepository.findByUser(user))
      playlists.add(Pair.of(p.getId(), Pair.of(p.getName(), p.getImage())));
    userDataResponse.setPlaylists(playlists);

    List<Long> likes = new ArrayList<Long>();
    for(Likes l : likesRepository.findByLocalUser(user))
      likes.add(l.getSong().getId());

    userDataResponse.setLikes(likes);
    return userDataResponse;
  }
}
