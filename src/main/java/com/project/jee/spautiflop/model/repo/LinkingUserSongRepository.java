package com.project.jee.spautiflop.model.repo;

import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.linking_model.LinkingUserSong;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LinkingUserSongRepository extends CrudRepository<LinkingUserSong, Long> {
  List<LinkingUserSong> findByLocalUser(LocalUser localUser);

  List<LinkingUserSong> findBySong(Song song);


}
