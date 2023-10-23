package com.project.jee.spautiflop.model.repo;

import com.project.jee.spautiflop.model.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long>{

  @Override
  Optional<Song> findById(Long aLong);

  List<Song> findByGenreIgnoreCase(String genre);

  List<Song> findByNameContainsIgnoreCase(String name);
}
