package com.project.jee.spautiflop.model.repo;

import com.project.jee.spautiflop.model.Playlist;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.links.Playlist_Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface Playlist_SongRepository extends CrudRepository<Playlist_Song, Long> {
    List<Playlist_Song> findBySong_Id(Long id);
    List<Playlist_Song> findByPlaylist(Playlist playlist);

    Optional<Playlist_Song> findByPlaylistAndSong(Playlist playlist, Song song);

}
