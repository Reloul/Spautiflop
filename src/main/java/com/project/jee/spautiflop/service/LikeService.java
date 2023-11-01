package com.project.jee.spautiflop.service;

import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.Song;
import com.project.jee.spautiflop.model.links.Likes;
import com.project.jee.spautiflop.model.repo.LikesRepository;
import com.project.jee.spautiflop.model.repo.SongRepository;
import com.project.jee.spautiflop.model.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {

    private final LikesRepository likesRepository;
    private final SongRepository songRepository;
    private final UserRepository userRepository;

    public LikeService(LikesRepository likesRepository, SongRepository songRepository, UserRepository userRepository) {
        this.likesRepository = likesRepository;
        this.songRepository = songRepository;
        this.userRepository = userRepository;
    }

    public Likes likeSong(LocalUser user, Song song) {
        if(this.likesRepository.findByLocalUserAndSong(user, song).isPresent())
            throw new RuntimeException("User already liked this song");

        Likes like = new Likes();

        like.setSong(song);
        like.setLocalUser(user);

        return this.likesRepository.save(like);
    }

    public Likes likeSong(Long userId, Long songId) throws RuntimeException{
        Optional<LocalUser> opUser = this.userRepository.findById(userId);
        Optional<Song> opSong = this.songRepository.findById(songId);

        if(opUser.isPresent() && opSong.isPresent())
            return this.likeSong(opUser.get(), opSong.get());
        else
            throw new RuntimeException("User or song not found");
    }
    public void unlikeSong(LocalUser user, Song song) throws RuntimeException{
        Optional<Likes> opLike = this.likesRepository.findByLocalUserAndSong(user, song);

        if(opLike.isPresent())
            this.likesRepository.delete(opLike.get());
        else
            throw new RuntimeException("User didn't like this song");
    }

    public void unlikeSong(Long userId, Long songId) throws RuntimeException{
        Optional<LocalUser> opUser = this.userRepository.findById(userId);
        Optional<Song> opSong = this.songRepository.findById(songId);

        if(opUser.isPresent() && opSong.isPresent())
            this.unlikeSong(opUser.get(), opSong.get());
        else
            throw new RuntimeException("User or song not found");
    }
}
