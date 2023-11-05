package com.project.jee.spautiflop.service;

import com.project.jee.spautiflop.model.Album;
import com.project.jee.spautiflop.model.Artist;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.repo.AlbumRepository;
import com.project.jee.spautiflop.model.repo.ArtistRepository;
import com.project.jee.spautiflop.model.repo.SongRepository;
import com.project.jee.spautiflop.vue.model.AlbumDataResponse;
import com.project.jee.spautiflop.vue.model.ArtistDataResponse;
import com.project.jee.spautiflop.vue.model.SearchDataResponse;
import com.project.jee.spautiflop.vue.model.SongDataResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private final SongService songService;
    private final ArtistService artistService;
    private final AlbumService albumService;
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public SearchService(SongService songService, ArtistService artistService, AlbumService albumService, SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.songService = songService;
        this.artistService = artistService;
        this.albumService = albumService;
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    public List<Song> searchSongs(String query) {
        return this.songRepository.findByNameContainsIgnoreCase(query);
    }

    public List<Artist> searchArtists(String query) {
        return this.artistRepository.findByNameContainsIgnoreCase(query);
    }

    public List<Album> searchAlbums(String query) {
        return this.albumRepository.findByNameContainsIgnoreCase(query);
    }

    public Song searchBestMatchSong(String query) {
        List<Song> songs = this.searchSongs(query);
        if(songs.isEmpty())
            return null;
        return songs.get(0);
    }

    public SearchDataResponse search(String query) {
        SearchDataResponse searchDataResponse = new SearchDataResponse();

        List<Song> songs = this.searchSongs(query);
        if(songs.size() < 4)
            songs.addAll(songService.getRandomSongs(4 - songs.size()));
        else if (songs.size() > 4) {
            songs = songs.subList(0, 4);
        }

        List<Artist> artists = this.searchArtists(query);
        if (artists.size() < 4)
            artists.addAll(artistService.getRandomArtists(4 - artists.size()));
        else if (artists.size() > 4)
            artists = artists.subList(0, 4);

        List<Album> albums = this.searchAlbums(query);
        if (albums.size() < 4)
            albums.addAll(albumService.getRandomAlbums(4 - albums.size()));
        else if (albums.size() > 4)
            albums = albums.subList(0, 4);


        List<SongDataResponse> songDataResponses = new ArrayList<>();
        songs.forEach(song -> {
            songDataResponses.add(new SongDataResponse(song));
        });
        searchDataResponse.setSongs(songDataResponses);
        searchDataResponse.setBestMatchSong(songDataResponses.get(0));

        List<ArtistDataResponse> artistDataResponses = new ArrayList<>();
        artists.forEach(artist -> {
            artistDataResponses.add(new ArtistDataResponse(artist));
        });
        searchDataResponse.setArtists(artistDataResponses);

        List<AlbumDataResponse> albumDataResponses = new ArrayList<>();
        albums.forEach(album -> {
            albumDataResponses.add(new AlbumDataResponse(album));
        });
        searchDataResponse.setAlbums(albumDataResponses);

        return searchDataResponse;
    }
}
