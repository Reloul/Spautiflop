package com.project.jee.spautiflop.model.repo;

import com.project.jee.spautiflop.model.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends CrudRepository<Album, Long> {
  List<Album> findByNameContainsIgnoreCase(String name);

  Optional<Album> findByNameIgnoreCase(String name);


}
