package com.project.jee.spautiflop.service;

import com.project.jee.spautiflop.exception.ArtistAlreadyExistsException;
import com.project.jee.spautiflop.model.Album;
import com.project.jee.spautiflop.model.Artist;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.repo.*;
import com.project.jee.spautiflop.vue.model.AlbumRegisterBody;
import com.project.jee.spautiflop.vue.model.ArtistRegisterBody;
import com.project.jee.spautiflop.vue.model.SongRegistrationBody;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
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
  private final LikesRepository likesRepository;

  public SongService(SongRepository songRepository, ArtistRepository artistRepository, PlaylistRepository playlistRepository, ArtistService artistService, AlbumService albumService, AlbumRepository albumRepository, FileService fileService, LikesRepository likesRepository){
    this.songRepository = songRepository;
    this.artistRepository = artistRepository;
    this.playlistRepository = playlistRepository;
    this.artistService = artistService;
    this.albumService = albumService;
    this.albumRepository = albumRepository;
    this.fileService = fileService;
    this.likesRepository = likesRepository;
  }

  public Song registerSong(@Valid SongRegistrationBody songRegistrationBody) throws IOException, IllegalArgumentException, ArtistAlreadyExistsException, UnknownServiceException
  {
    Song song = new Song();
    song.setName(songRegistrationBody.getName());

    Optional<Artist> opArtist = artistRepository.findByNameIgnoreCase(songRegistrationBody.getArtist());
    /* if artist exists, add song to artist's list of songs
      * else, create artist and add song to artist's list of songs
      */
    Artist artist;
    if( opArtist.isPresent() ) {
      artist = opArtist.get();
    } else {
      ArtistRegisterBody artistRegisterBody = new ArtistRegisterBody();
      artistRegisterBody.setName(songRegistrationBody.getArtist());
      try {
        artist = artistService.registerArtist(artistRegisterBody);
      } catch (IOException e) {
        throw new IOException(e.getMessage() + " : invalid image file in artist registration");
      } catch (ArtistAlreadyExistsException e) {
        throw new ArtistAlreadyExistsException(e.getMessage() + " : invalid artist name in song registration");
      }
    }

    song.setArtist(artist);
    artistService.addSongToArtist(artist, song);

    /* if an album is given */
    if(songRegistrationBody.getAlbum() != null)
    {
      List<Album> opAlbum = albumRepository.findByNameContainsIgnoreCase(songRegistrationBody.getAlbum());
      /* if album exists, add song to album's list of songs
       * else, create album and add song to album's list of songs
       */
      Album album;

      if( opAlbum.stream().anyMatch(album1 -> artist.getAlbums().contains(album1))) {
        album = opAlbum.stream().filter(album1 -> artist.getAlbums().contains(album1)).findFirst().get();
      } else {
        AlbumRegisterBody albumRegisterBody = new AlbumRegisterBody();
        albumRegisterBody.setName(songRegistrationBody.getAlbum());
        albumRegisterBody.setCover(songRegistrationBody.getCover());
        albumRegisterBody.setArtist(song.getArtist().getName());
        try {
          album = albumService.registerAlbum(albumRegisterBody);
        } catch (Exception e) {
          throw new UnknownServiceException(e.getMessage() + " : in song registration : album registration failed abnormally");
        }
      }

      song.setAlbum(album);
      albumService.addSongToAlbum(album, song);
    }

    /* else it's an single album => it take the name of the song */
    else {
      AlbumRegisterBody albumRegisterBody = new AlbumRegisterBody();
      albumRegisterBody.setName(song.getName());
      albumRegisterBody.setCover(songRegistrationBody.getCover());
      albumRegisterBody.setArtist(song.getArtist().getName());

      try {
        Album album = albumService.registerAlbum(albumRegisterBody);
        song.setAlbum(album);
        albumService.addSongToAlbum(album, song);
      } catch (IOException e) {
        throw new IOException(e.getMessage() + " : invalid image file in album registration");
      }
    }

    song.setGenre("");
    if(songRegistrationBody.getGenre() != null)
      song.setGenre(songRegistrationBody.getGenre());

    song.setNbLikes(new Long(0));

    /* If a audio is provided, check if it is an image and save it */
    try{
      song.setMusicLink(fileService.uploadMusic(songRegistrationBody.getMusic()));
    } catch (IOException e) {
      throw new IOException("Error while saving video  : " + e.getMessage());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("No music provided");
    }

    try {
      song.setImage(fileService.uploadImage(songRegistrationBody.getCover()));
    } catch (Exception e) {
      song.setImage(fileService.DEFAULT_ALBUM());
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

  public Song getSong(long id) throws IllegalArgumentException {
    Optional<Song> opSong = this.songRepository.findById(id);
    if(opSong.isPresent()){
      Song song = opSong.get();
      song.setNbLikes(likesRepository.countBySong(song));
        return song;
    }
    else
      throw new IllegalArgumentException("Song not found");
  }

    public List<Song> getTopSongs(int nb) {
        List<Song> topSongs = new ArrayList<Song>();
        songRepository.findAll().forEach(topSongs::add);
        topSongs.sort((s1, s2) -> s2.getNbLikes().compareTo(s1.getNbLikes()));

        return topSongs.subList(0, Math.min(nb, topSongs.size()));
    }
}
