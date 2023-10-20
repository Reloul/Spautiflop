package com.project.jee.spautiflop.service;

import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.repo.UserRepository;
import com.project.jee.spautiflop.vue.model.UserRegistrationBody;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public LocalUser registerUser(UserRegistrationBody userRegistrationBody) {
    LocalUser user = new LocalUser();
    user.setPseudo(userRegistrationBody.getPseudo());

    //TODO : encrypt password
    user.setPassword(userRegistrationBody.getPassword());

    //TODO : save photo in folder and save path in database
    //user.setPhoto(userRegistrationBody.getPhoto().getOriginalFilename());
    user.setPhoto(userRegistrationBody.getImage());
    return this.userRepository.save(user);
  }
}
