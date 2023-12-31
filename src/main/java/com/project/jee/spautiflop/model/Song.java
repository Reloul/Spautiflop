package com.project.jee.spautiflop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.jee.spautiflop.model.links.Likes;
import com.project.jee.spautiflop.model.links.Playlist_Song;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "song")
public class Song {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "image")
  private String image;

  @Column(name = "nb_likes", nullable = false)
  private Long nbLikes;

  @Column(name = "genre")
  private String genre;

  @Column(name = "music_link", nullable = false, unique = true)
  private String musicLink;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "album_id")
  private Album album;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "artist_id")
  private Artist artist;

  @JsonIgnore
  @OneToMany(mappedBy = "song", orphanRemoval = true)
  private Set<Likes> likes = new LinkedHashSet<>();

 @JsonIgnore
  @OneToMany(mappedBy = "song", orphanRemoval = true)
  private Set<Playlist_Song> playlist_Songs = new LinkedHashSet<>();

}