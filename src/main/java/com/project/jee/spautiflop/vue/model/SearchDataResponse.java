package com.project.jee.spautiflop.vue.model;

import lombok.Getter;
import lombok.Setter;

import  java.util.List;

@Getter
@Setter
public class SearchDataResponse {

    private SongDataResponse bestMatchSong;

    private List<SongDataResponse> songs;

    private List<ArtistDataResponse> artists;

    private List<AlbumDataResponse> albums;
}
