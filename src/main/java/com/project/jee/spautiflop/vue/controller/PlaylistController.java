package com.project.jee.spautiflop.vue.controller;

import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.Playlist;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.links.Playlist_Song;
import com.project.jee.spautiflop.model.repo.PlaylistRepository;
import com.project.jee.spautiflop.model.repo.Playlist_SongRepository;
import com.project.jee.spautiflop.model.repo.SongRepository;
import com.project.jee.spautiflop.vue.model.PlaylistDataResponse;
import com.project.jee.spautiflop.vue.model.PlaylistRegisterBody;
import com.project.jee.spautiflop.vue.model.SongDataResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import com.project.jee.spautiflop.service.PlaylistService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    private final PlaylistService playlistService;
    private final PlaylistRepository playlistRepository;
    private final Playlist_SongRepository playlist_songRepository;
    private final SongRepository songRepository;

    public PlaylistController(PlaylistService playlistService, PlaylistRepository playlistRepository, Playlist_SongRepository playlist_songRepository,
                              SongRepository songRepository){
        this.playlistService = playlistService;
        this.playlistRepository = playlistRepository;
        this.playlist_songRepository = playlist_songRepository;
        this.songRepository = songRepository;
    }

    @PostMapping(value="/add", consumes = {"multipart/form-data"})
    public ResponseEntity<Playlist> registerPlaylist(@AuthenticationPrincipal LocalUser user, @Valid @RequestBody @ModelAttribute PlaylistRegisterBody playlistRegisterBody){
        try {
            return ResponseEntity.ok(playlistService.registerPlaylist(playlistRegisterBody, user));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistDataResponse> getPlaylist(@AuthenticationPrincipal LocalUser user ,@PathVariable("id") Long id){
        Playlist playlist = playlistRepository.findById(id).orElse(null);
        if(playlist == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        PlaylistDataResponse playlistDataResponse = new PlaylistDataResponse(playlist);
        List<SongDataResponse> songs = new ArrayList<SongDataResponse>();
        for (Playlist_Song ps : playlist_songRepository.findByPlaylist(playlist)) {
            songs.add(new SongDataResponse( ps.getSong()));
        }
        playlistDataResponse.setSongs(songs);

        return ResponseEntity.ok(playlistDataResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlaylist(@AuthenticationPrincipal LocalUser user, @PathVariable("id") Long id){
        Playlist playlist = playlistRepository.findById(id).orElse(null);
        if(playlist == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if(!playlist.getUser().getId().equals(user.getId())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        playlistService.deletePlaylist(playlist);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/addSong/{songId}")
    public ResponseEntity<?> addSongToPlaylist(@AuthenticationPrincipal LocalUser user, @PathVariable("id") Long id, @PathVariable("songId") Long songId){
        Playlist playlist = playlistRepository.findById(id).orElse(null);
        Song song = songRepository.findById(songId).orElse(null);

        if(playlist == null || song == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if(!playlist.getUser().getId().equals(user.getId())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        try {
            playlistService.addSongToPlaylist(playlist, song);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/removeSong/{songId}")
    public ResponseEntity<?> removeSongFromPlaylist(@AuthenticationPrincipal LocalUser user, @PathVariable("id") Long id, @PathVariable("songId") Long songId){
        Playlist playlist = playlistRepository.findById(id).orElse(null);
        Song song = songRepository.findById(songId).orElse(null);

        if(playlist == null || song == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if(!playlist.getUser().getId().equals(user.getId())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        try {
            playlistService.removeSongFromPlaylist(playlist, song);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/containsSong/{id}")
    public ResponseEntity<List<Playlist>> GetPlaylists(@AuthenticationPrincipal LocalUser user , @PathVariable("id") @Valid @RequestBody @ModelAttribute Long id) {
        try {
            return ResponseEntity.ok(this.playlistService.getPlaylistsWithSong(user, id));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
