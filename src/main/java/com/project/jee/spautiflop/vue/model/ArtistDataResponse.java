package com.project.jee.spautiflop.vue.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.jee.spautiflop.model.Album;
import com.project.jee.spautiflop.model.Artist;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.repo.LikesRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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
    private List<SongDataResponse> bestSongs;

    @NotNull
    @NotBlank
    private List<AlbumDataResponse> albums;

    @NotNull
    @NotBlank
    private String photo;

    public ArtistDataResponse(Artist artist) {
        this.id = artist.getId();
        this.name = artist.getName();
        this.bestSongs = new ArrayList<SongDataResponse>();

        /* top 5 songs */
        List<Song> top5 = new ArrayList<Song>(artist.getSongs());
        top5.sort((s1, s2) -> s2.getNbLikes().compareTo(s1.getNbLikes()));
        for (int i = 0; i < 5 && i < top5.size(); i++) {
            this.bestSongs.add(new SongDataResponse(top5.get(i)));
        }

        this.albums = new ArrayList<AlbumDataResponse>();
        artist.getAlbums().forEach(album -> {
            this.albums.add(new AlbumDataResponse(album));
        });
        this.photo = artist.getPhoto();
    }
}
