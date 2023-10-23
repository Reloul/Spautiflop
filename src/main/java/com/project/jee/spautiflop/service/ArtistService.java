package com.project.jee.spautiflop.service;

import com.project.jee.spautiflop.model.Artist;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.repo.ArtistRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

  private final ArtistRepository artistRepository;

  public ArtistService(ArtistRepository artistRepository)
  {
    this.artistRepository = artistRepository;
  }

  public Artist registerArtist(String name)
  {
    Artist artist = new Artist();
    artist.setName(name);
    artistRepository.save(artist);
    return artist;
  }

  public void addSongToArtist(Artist artist, Song song)
  {
    artist.getSongs().add(song);
    artistRepository.save(artist);
  }
}
