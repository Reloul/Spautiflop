package com.project.jee.spautiflop.vue.model;

import com.project.jee.spautiflop.model.Album;
import com.project.jee.spautiflop.model.Artist;
import com.project.jee.spautiflop.model.Song;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SongDataResponse {

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
    private Long nbLikes;

    @NotNull
    @NotBlank
    private String genre;

    @NotNull
    @NotBlank
    private String musicLink;

    @NotNull
    @NotBlank
    private Album album;

    @NotNull
    @NotBlank
    private Artist artist;

    public SongDataResponse(Song song) {
        this.id = song.getId();
        this.name = song.getName();
        this.image = song.getImage();
        this.nbLikes = song.getNbLikes();
        this.genre = song.getGenre();
        this.musicLink = song.getMusicLink();
        this.album = song.getAlbum();
        this.artist = song.getArtist();
    }
}
