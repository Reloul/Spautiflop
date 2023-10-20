package com.project.jee.spautiflop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "artist")
public class Artist {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @OneToMany(mappedBy = "artist", orphanRemoval = true)
  private Set<Song> songs = new LinkedHashSet<>();

  @OneToMany(mappedBy = "artist", orphanRemoval = true)
  private Set<Album> albums = new LinkedHashSet<>();

}