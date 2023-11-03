package com.project.jee.spautiflop.vue.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.Playlist;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.links.Playlist_Song;
import com.project.jee.spautiflop.model.repo.Playlist_SongRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PlaylistDataResponse {

    @NotNull
    @NotBlank
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String image;

    @NotNull
    @NotBlank
    private LocalUser user;

    @NotNull
    @NotBlank
    private List<SongDataResponse> songs;

    public PlaylistDataResponse(Playlist playlist) {
        this.id = playlist.getId();
        this.name = playlist.getName();
        this.image = playlist.getImage();
        this.user = playlist.getUser();
    }
}
