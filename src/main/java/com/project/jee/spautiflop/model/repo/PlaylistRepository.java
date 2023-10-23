package com.project.jee.spautiflop.model.repo;

import com.project.jee.spautiflop.model.Playlist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
  List<Playlist> findByNameContainsIgnoreCase(String name);
}
