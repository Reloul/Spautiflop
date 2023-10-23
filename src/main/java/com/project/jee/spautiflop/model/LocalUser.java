package com.project.jee.spautiflop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.jee.spautiflop.model.linking_model.LinkingUserSong;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "local_user")
public class LocalUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "pseudo", nullable = false, unique = true)
  private String pseudo;

  @Column(name = "photo", nullable = false)
  private String photo;

  @JsonIgnore
  @Column(name = "password", nullable = false, length = 1000)
  private String password;

  @JsonIgnore
  @OneToMany(mappedBy = "user", orphanRemoval = true)
  private List<Playlist> playlists = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "localUser", orphanRemoval = true)
  private List<LinkingUserSong> songLiked = new ArrayList<>();

}