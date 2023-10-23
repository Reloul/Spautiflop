package com.project.jee.spautiflop.model.repo;

import com.project.jee.spautiflop.model.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
  List<Artist> findByNameContainsIgnoreCase(String name);

}
