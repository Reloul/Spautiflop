package com.project.jee.spautiflop.model.repo;

import com.project.jee.spautiflop.model.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {
  List<Album> findByNameContainsIgnoreCase(String name);

}
