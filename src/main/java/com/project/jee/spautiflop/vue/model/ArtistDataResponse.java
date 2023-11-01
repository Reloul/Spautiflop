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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ArtistDataResponse {

    @NotNull
    @NotBlank
    private Long id;

    @NotNull
    @NotBlank
    private String name;


    @NotNull
    @NotBlank
    private List<Song> bestSongs;
    @NotNull
    @NotBlank
    private List<Album> albums;

    @NotNull
    @NotBlank
    private String photo;

    public ArtistDataResponse(Artist artist) {
        this.id = artist.getId();
        this.name = artist.getName();
        this.bestSongs = new ArrayList<Song>();
        this.bestSongs.addAll(artist.getSongs());
        this.albums = new ArrayList<Album>();
        this.albums.addAll(artist.getAlbums());
        this.photo = artist.getPhoto();
    }
}
