package com.project.jee.spautiflop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
  @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
  private List<Playlist> playlists = new ArrayList<>();

  @JsonIgnore
  @ManyToMany
  @JoinTable(name = "local_user_songs",
          joinColumns = @JoinColumn(name = "localUser_id"),
          inverseJoinColumns = @JoinColumn(name = "songs_id"))
  private Set<Song> songsLiked = new LinkedHashSet<>();

}