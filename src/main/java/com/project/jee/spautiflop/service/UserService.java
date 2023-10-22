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
  private final String pathDirectory = System.getProperty("user.dir") + "/src/main/resources/static/images/";
  private static final String defaultPhoto = "default.png";

  public UserService(UserRepository userRepository, EncryptionService encryptionService, JsonWebTokenService JsonWebTokenService) {
    this.userRepository = userRepository;
    this.encryptionService = encryptionService;
    this.JsonWebTokenService = JsonWebTokenService;
  }

  public LocalUser registerUser(@Valid UserRegistrationBody userRegistrationBody) throws UserAlreadyExistsException, IOException {

    if( this.userRepository.findByPseudoIgnoreCase(userRegistrationBody.getPseudo()).isPresent() )
      throw new UserAlreadyExistsException("User already exists");

    LocalUser user = new LocalUser();
    user.setPseudo(userRegistrationBody.getPseudo());
    user.setPassword(this.encryptionService.encryptPwd(userRegistrationBody.getPassword()));

    /* If no photo is provided, set the default one */
    if(userRegistrationBody.getPhoto() == null || userRegistrationBody.getPhoto().isEmpty())
      user.setPhoto(pathDirectory +  defaultPhoto);

    /* If a photo is provided, check if it is an image and save it */
    else if(userRegistrationBody.getPhoto().getContentType() == null || !userRegistrationBody.getPhoto().getContentType().startsWith("image/") || !ImageIO.read(userRegistrationBody.getPhoto().getInputStream()).getClass().getSimpleName().equals("BufferedImage"))
      throw new IOException("File is not an image");

    else {
      String filePath = this.pathDirectory + String.valueOf(System.currentTimeMillis()) + userRegistrationBody.getPhoto().getOriginalFilename();

      if(filePath.length()>255)
        throw new IOException("File name too long");

      user.setPhoto(filePath);

      System.out.println(pathDirectory);
      try{
        userRegistrationBody.getPhoto().transferTo(new File(filePath));
      } catch (IOException e) {
        throw new IOException("Error while saving photo  : " + e.getMessage());
      }
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
