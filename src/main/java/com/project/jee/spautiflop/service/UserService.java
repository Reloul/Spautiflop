package com.project.jee.spautiflop.service;

import com.project.jee.spautiflop.exception.UserAlreadyExistsException;
import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.repo.UserRepository;
import com.project.jee.spautiflop.vue.model.UserLoginBody;
import com.project.jee.spautiflop.vue.model.UserRegistrationBody;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final EncryptionService encryptionService;
  private final JsonWebTokenService JsonWebTokenService;
  private final FileService fileService;
  public UserService(UserRepository userRepository, EncryptionService encryptionService, JsonWebTokenService JsonWebTokenService, FileService fileService) {
    this.userRepository = userRepository;
    this.encryptionService = encryptionService;
    this.JsonWebTokenService = JsonWebTokenService;
    this.fileService = fileService;
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

}
