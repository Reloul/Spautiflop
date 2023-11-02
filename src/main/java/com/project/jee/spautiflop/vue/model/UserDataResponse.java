package com.project.jee.spautiflop.vue.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.Playlist;
import com.project.jee.spautiflop.model.links.Likes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDataResponse {

    @NotNull
    @NotBlank
    private Long id;

    @NotNull
    @NotBlank
    private String pseudo;

    @NotNull
    @NotBlank
    private String photo;

    @NotNull
    @NotBlank
    private List<Pair<Long, String>> playlists;

    @NotNull
    @NotBlank
    private List<Long> likes;

    public UserDataResponse(LocalUser user) {
        this.id = user.getId();
        this.pseudo = user.getPseudo();
        this.photo = user.getPhoto();
    }
}
