package com.project.jee.spautiflop.model.repo;

import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<LocalUser, Long> {
  List<LocalUser> findBySongsLiked_Id(Long id);
  Optional<LocalUser> findByPseudoIgnoreCase(String pseudo);

}
