package com.project.jee.spautiflop.vue.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.jee.spautiflop.model.Album;
import com.project.jee.spautiflop.model.Artist;
import com.project.jee.spautiflop.model.Song;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AlbumDataResponse {

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
    private String release;

    @NotNull
    @NotBlank
    private List<Song> songs = new ArrayList<>();

    @NotNull
    @NotBlank
    private Artist artist;

    public AlbumDataResponse(Album album) {
        this.id = album.getId();
        this.name = album.getName();
        this.image = album.getImage();
        this.release = album.getRelease();
        this.songs = album.getSongs();
        this.artist = album.getArtist();
    }

}
