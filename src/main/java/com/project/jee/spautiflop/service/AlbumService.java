package com.project.jee.spautiflop.service;

import com.project.jee.spautiflop.exception.ArtistAlreadyExistsException;
import com.project.jee.spautiflop.model.Album;
import com.project.jee.spautiflop.model.Artist;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.repo.AlbumRepository;
import com.project.jee.spautiflop.model.repo.ArtistRepository;
import com.project.jee.spautiflop.vue.model.AlbumRegisterBody;
import com.project.jee.spautiflop.vue.model.ArtistRegisterBody;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class AlbumService {

  private final AlbumRepository albumRepository;
  private final ArtistRepository artistRepository;
  private final ArtistService artistService;
  private final FileService fileService;

  public AlbumService (AlbumRepository albumRepository, ArtistRepository artistRepository, ArtistService artistService, FileService fileService)
  {
    this.albumRepository = albumRepository;
    this.artistRepository = artistRepository;
    this.artistService = artistService;
    this.fileService = fileService;
  }

  public Album registerAlbum(@Valid AlbumRegisterBody albumRegisterBody) throws IOException, IllegalArgumentException, ArtistAlreadyExistsException
  {
    Album album = new Album();
    album.setName(albumRegisterBody.getName());
    Optional<Artist> opArtist = artistRepository.findByNameIgnoreCase(albumRegisterBody.getArtist());
    Artist artist;
    if(opArtist.isPresent()) {
      artist = opArtist.get();
    } else {
      ArtistRegisterBody artistRegisterBody = new ArtistRegisterBody();
      artistRegisterBody.setName(albumRegisterBody.getArtist());
      try {
        artist =  artistService.registerArtist(artistRegisterBody);
      } catch (ArtistAlreadyExistsException e) {
        throw new ArtistAlreadyExistsException(e.getMessage() + " : invalid artist name in album registration");
      } catch (IOException e) {
        throw new IOException(e.getMessage() + " : invalid image file in album registration");
      } catch (Exception e) {
        throw new IllegalArgumentException(e.getMessage() + " : invalid artist name in album registration");
      }

    }
    System.out.println( artist.getName());
    album.setArtist(artist);
    this.artistService.addAlbumToArtist(artist, album);

    if(albumRegisterBody.getRelease() != null) {
      album.setRelease(album.getRelease());
    } else {
      album.setRelease("");
    }

    try {
      album.setImage(fileService.uploadImage(albumRegisterBody.getCover()));
    } catch (IOException e) {
      throw new IOException(e.getMessage() + " : invalid image file in album registration");
    }

    return albumRepository.save(album);
  }

  public void addSongToAlbum(Album album, Song song)
  {
    album.getSongs().add(song);
    albumRepository.save(album);
  }

  public Album getAlbum(long id) {
    Optional<Album> opAlbum = albumRepository.findById(id);
    if(opAlbum.isPresent()) {
       return opAlbum.get();
    } else {
      throw new IllegalArgumentException("Album not found");
    }
  }

}
