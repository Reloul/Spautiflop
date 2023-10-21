package com.project.jee.spautiflop.service;

import com.project.jee.spautiflop.exception.UserAlreadyExistsException;
import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.repo.UserRepository;
import com.project.jee.spautiflop.vue.model.UserRegistrationBody;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final String pathDirectory = System.getProperty("user.dir") + "/src/main/resources/static/images/";

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public LocalUser registerUser(@Valid UserRegistrationBody userRegistrationBody) throws UserAlreadyExistsException, IOException {

    if( this.userRepository.findByPseudoIgnoreCase(userRegistrationBody.getPseudo()).isPresent() )
      throw new UserAlreadyExistsException("User already exists");

    if(userRegistrationBody.getPhoto().isEmpty() || userRegistrationBody.getPhoto().getContentType() == null || !userRegistrationBody.getPhoto().getContentType().startsWith("image/") || !ImageIO.read(userRegistrationBody.getPhoto().getInputStream()).getClass().getSimpleName().equals("BufferedImage"))
      throw new IOException("File is not an image");

    LocalUser user = new LocalUser();
    user.setPseudo(userRegistrationBody.getPseudo());

    //TODO : encrypt password
    user.setPassword(userRegistrationBody.getPassword());

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
    return this.userRepository.save(user);
  }

}
