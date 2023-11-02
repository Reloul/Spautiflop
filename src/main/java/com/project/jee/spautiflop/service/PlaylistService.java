package com.project.jee.spautiflop.service;

import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.Playlist;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.links.Likes;
import com.project.jee.spautiflop.model.links.Playlist_Song;
import com.project.jee.spautiflop.model.repo.PlaylistRepository;
import com.project.jee.spautiflop.model.repo.Playlist_SongRepository;
import com.project.jee.spautiflop.model.repo.SongRepository;
import com.project.jee.spautiflop.vue.model.PlaylistRegisterBody;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;
    private final Playlist_SongRepository playlist_songRepository;

    private final FileService fileService;

    public PlaylistService(PlaylistRepository playlistRepository, SongRepository songRepository, Playlist_SongRepository playlist_songRepository, FileService fileService){
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
        this.playlist_songRepository = playlist_songRepository;
        this.fileService = fileService;
    }

    public Playlist_Song addSongToPlaylist(Playlist playlist, Song song) throws RuntimeException {
        if(this.playlist_songRepository.findByPlaylistAndSong(playlist, song).isPresent())
            throw new RuntimeException("playlist already contains this song");

        Playlist_Song ps = new Playlist_Song();

        ps.setSong(song);
        ps.setPlaylist(playlist);

        return this.playlist_songRepository.save(ps);
    }

    public void removeSongFromPlaylist(Playlist playlist, Song song) throws RuntimeException {
        Optional<Playlist_Song> opPs = this.playlist_songRepository.findByPlaylistAndSong(playlist, song);

        if(opPs.isPresent()) {
            this.playlist_songRepository.delete(opPs.get());
        }
        else
            throw new RuntimeException("playlist doesn't contain this song");
    }



    public void deletePlaylist(Playlist playlist) {
        List<Playlist_Song> ps = this.playlist_songRepository.findByPlaylist(playlist);

        if(ps != null && !ps.isEmpty())
            this.playlist_songRepository.deleteAll(ps);

        this.playlistRepository.delete(playlist);
    }

    public Playlist registerPlaylist(@Valid PlaylistRegisterBody playlistRegisterBody, LocalUser localUser) throws IOException {

        Playlist playlist = new Playlist();

        playlist.setName(playlistRegisterBody.getName());

        try {
            playlist.setImage(fileService.uploadImage(playlistRegisterBody.getImage()));
        } catch (IOException e) {
            throw new IOException(e.getMessage() + " : invalid image file in album registration");
        }

        playlist.setUser(localUser);

        return playlistRepository.save(playlist);
    }
}
