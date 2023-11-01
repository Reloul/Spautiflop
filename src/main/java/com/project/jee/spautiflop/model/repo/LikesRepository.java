package com.project.jee.spautiflop.model.repo;

import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.links.Likes;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface LikesRepository extends CrudRepository<Likes, Long> {
    Optional<Likes> findByLocalUserAndSong(LocalUser localUser, Song song);


}
