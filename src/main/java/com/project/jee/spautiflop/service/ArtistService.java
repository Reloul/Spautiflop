package com.project.jee.spautiflop.service;

import com.project.jee.spautiflop.exception.ArtistAlreadyExistsException;
import com.project.jee.spautiflop.exception.UserAlreadyExistsException;
import com.project.jee.spautiflop.model.Album;
import com.project.jee.spautiflop.model.Artist;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.repo.ArtistRepository;
import com.project.jee.spautiflop.vue.model.ArtistRegisterBody;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class ArtistService {

  private final ArtistRepository artistRepository;
  private final FileService fileService;

  public ArtistService(ArtistRepository artistRepository, FileService fileService)
  {
    this.artistRepository = artistRepository;
    this.fileService = fileService;
  }

  public Artist registerArtist(@Valid ArtistRegisterBody artistRegisterBody) throws IOException, ArtistAlreadyExistsException
  {
    if( this.artistRepository.findByNameIgnoreCase(artistRegisterBody.getName()).isPresent() )
      throw new ArtistAlreadyExistsException("User already exists");

    Artist artist = new Artist();
    artist.setName(artistRegisterBody.getName());

    try {
      artist.setPhoto(fileService.uploadImage(artistRegisterBody.getCover()));
    } catch (IOException e) {
      throw new IOException(e.getMessage() + " : invalid image file in artist registration");
    }

    return artistRepository.save(artist);
  }

  public void addSongToArtist(Artist artist, Song song)
  {
    artist.getSongs().add(song);
    artistRepository.save(artist);
  }

  public void addAlbumToArtist(Artist artist, Album album)
  {
    artist.getAlbums().add(album);
    artistRepository.save(artist);
  }


  public Artist getArtist(Long id) {
    Optional<Artist> artist = this.artistRepository.findById(id);
    if(artist.isPresent())
      return artist.get();
    else
      throw new IllegalArgumentException("Artist not found");
  }
}
