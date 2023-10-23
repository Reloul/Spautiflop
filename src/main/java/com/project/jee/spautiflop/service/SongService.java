package com.project.jee.spautiflop.service;

import com.project.jee.spautiflop.model.Album;
import com.project.jee.spautiflop.model.Artist;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.repo.AlbumRepository;
import com.project.jee.spautiflop.model.repo.ArtistRepository;
import com.project.jee.spautiflop.model.repo.PlaylistRepository;
import com.project.jee.spautiflop.model.repo.SongRepository;
import com.project.jee.spautiflop.vue.model.SongRegistrationBody;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class SongService {

  private final SongRepository songRepository;
  private final ArtistRepository artistRepository;
  private final PlaylistRepository playlistRepository;
  private final AlbumRepository albumRepository;
  private final FileService fileService;
  private final ArtistService artistService;
  private final AlbumService albumService;

  public SongService(SongRepository songRepository, ArtistRepository artistRepository, PlaylistRepository playlistRepository, ArtistService artistService, AlbumService albumService, AlbumRepository albumRepository, FileService fileService){
    this.songRepository = songRepository;
    this.artistRepository = artistRepository;
    this.playlistRepository = playlistRepository;
    this.artistService = artistService;
    this.albumService = albumService;
    this.albumRepository = albumRepository;
    this.fileService = fileService;
  }

  public Song registerSong(@Valid SongRegistrationBody songRegistrationBody) throws IOException, IllegalArgumentException{

    Song song = new Song();
    song.setName(songRegistrationBody.getName());

    if(songRegistrationBody.getArtist() != null)
    {
      Optional<Artist> opArtist = artistRepository.findByNameIgnoreCase(songRegistrationBody.getArtist());
      /* if artist exists, add song to artist's list of songs
       * else, create artist and add song to artist's list of songs
       */
      Artist artist;
      if( opArtist.isPresent() ) {
        artist = opArtist.get();
      } else {
        artist = artistService.registerArtist(songRegistrationBody.getArtist());
      }

      song.setArtist(artist);
      artistService.addSongToArtist(artist, song);
    }

    if(songRegistrationBody.getAlbum() != null)
    {
      Optional<Album> opAlbum = albumRepository.findByNameIgnoreCase(songRegistrationBody.getAlbum());
      /* if album exists, add song to album's list of songs
       * else, create album and add song to album's list of songs
       */
      Album album;
      if( opAlbum.isPresent() ) {
        album = opAlbum.get();
      } else {
        album = albumService.registerAlbum(songRegistrationBody.getAlbum());
      }

      song.setAlbum(album);
      albumService.addSongToAlbum(album, song);
    }

    if(songRegistrationBody.getGenre() != null)
      song.setGenre(songRegistrationBody.getGenre());

    song.setNbLikes(new Long(0));

    /* If a photo is provided, check if it is an image and save it */
    try{
      song.setMusicLink(fileService.uploadMusic(songRegistrationBody.getMusic()));
    } catch (IOException e) {
      throw new IOException("Error while saving photo  : " + e.getMessage());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("No music provided");
    }

    return songRepository.save(song);
  }

  public void addArtistToSong(Song song, Artist artist)
  {
    song.setArtist(artist);
    songRepository.save(song);
  }

  public void addAlbumToSong(Song song, Album album)
  {
    song.setAlbum(album);
    songRepository.save(song);
  }
}
