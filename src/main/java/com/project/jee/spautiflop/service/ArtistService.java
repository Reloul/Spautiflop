package com.project.jee.spautiflop.service;

import com.project.jee.spautiflop.model.repo.ArtistRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

  private ArtistRepository artistRepository;

  public ArtistService(ArtistRepository artistRepository)
  {
    this.artistRepository = artistRepository;
  }
}
