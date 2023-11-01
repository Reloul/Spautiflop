package com.project.jee.spautiflop.service;

import com.project.jee.spautiflop.exception.UserAlreadyExistsException;
import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.repo.UserRepository;
import com.project.jee.spautiflop.vue.model.UserLoginBody;
import com.project.jee.spautiflop.vue.model.UserRegistrationBody;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final EncryptionService encryptionService;
  private final JsonWebTokenService JsonWebTokenService;
  private final FileService fileService;
  private final SongService songService;
  private final LikeService likeService;
  public UserService(UserRepository userRepository, EncryptionService encryptionService, JsonWebTokenService JsonWebTokenService, FileService fileService, SongService songService, LikeService likeService) {
    this.userRepository = userRepository;
    this.encryptionService = encryptionService;
    this.JsonWebTokenService = JsonWebTokenService;
    this.fileService = fileService;
    this.songService = songService;
    this.likeService = likeService;
  }

  public LocalUser registerUser(@Valid UserRegistrationBody userRegistrationBody) throws UserAlreadyExistsException, IOException {

    if( this.userRepository.findByPseudoIgnoreCase(userRegistrationBody.getPseudo()).isPresent() )
      throw new UserAlreadyExistsException("User already exists");

    LocalUser user = new LocalUser();
    user.setPseudo(userRegistrationBody.getPseudo());
    user.setPassword(this.encryptionService.encryptPwd(userRegistrationBody.getPassword()));

    try {
      user.setPhoto(this.fileService.uploadImage(userRegistrationBody.getPhoto()));
    } catch (IOException e) {
      System.out.println(e.getMessage());
      user.setPhoto(this.fileService.DEFAULT_IMAGE());
    }

    return this.userRepository.save(user);
  }

  public String loginUser(UserLoginBody userLoginBody) {
    Optional<LocalUser> user = this.userRepository.findByPseudoIgnoreCase(userLoginBody.getPseudo());

    if(user.isPresent())
    {
      LocalUser localUser = user.get();
      if(this.encryptionService.checkPwd(userLoginBody.getPassword(), localUser.getPassword()))
        return JsonWebTokenService.generateToken(localUser.getPseudo());
    }
    return null;
  }

  public void addSongToFav(LocalUser user, long songId) throws IllegalArgumentException , RuntimeException{
    Song song;
    try {
      song = this.songService.getSong(songId);
      likeService.likeSong(user, song);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(e.getMessage() + " : invalid song id in user's fav");
    } catch (RuntimeException e) {
      throw new RuntimeException(e.getMessage() + " : user already liked this song");
    }
  }

  public void removeSongFromFav(LocalUser user, long songId) throws IllegalArgumentException , RuntimeException{
    Song song;
    try {
      song = this.songService.getSong(songId);
      likeService.unlikeSong(user, song);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(e.getMessage() + " : invalid song id in user's fav");
    } catch (RuntimeException e) {
      throw new RuntimeException(e.getMessage() + " : user do not like this song");
    }
   }
}
