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

    LocalUser user = new LocalUser();
    user.setPseudo(userRegistrationBody.getPseudo());

    //TODO : encrypt password
    user.setPassword(userRegistrationBody.getPassword());

    //TODO : save photo in folder and save path in database

    user.setPhoto(userRegistrationBody.getPhoto().getOriginalFilename());

    System.out.println(pathDirectory);
    try{
      userRegistrationBody.getPhoto().transferTo(new File(this.pathDirectory+userRegistrationBody.getPhoto().getOriginalFilename()));
    } catch (IOException e) {
      throw new IOException("Error while saving photo  : " + e.getMessage());
    }
    return this.userRepository.save(user);
  }

}
