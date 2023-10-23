package com.project.jee.spautiflop.model.repo;

import com.project.jee.spautiflop.model.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
  Optional<Artist> findByNameIgnoreCase(String name);
  List<Artist> findByNameContainsIgnoreCase(String name);

}
