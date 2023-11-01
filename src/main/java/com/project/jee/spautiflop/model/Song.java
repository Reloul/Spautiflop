package com.project.jee.spautiflop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.jee.spautiflop.model.links.Likes;
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

  @ManyToOne
  @JoinColumn(name = "album_id")
  @JsonIgnore
  private Album album;

  @ManyToOne
  @JoinColumn(name = "artist_id")
  private Artist artist;

  @JsonIgnore
  @OneToMany(mappedBy = "song", orphanRemoval = true)
  private Set<Likes> likes = new LinkedHashSet<>();

}