package com.project.jee.spautiflop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

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

  @JsonIgnore
  @OneToMany(mappedBy = "artist", orphanRemoval = true)
  private Set<Song> songs = new LinkedHashSet<>();

  @JsonIgnore
  @OneToMany(mappedBy = "artist", orphanRemoval = true)
  private Set<Album> albums = new LinkedHashSet<>();

  @Column
  private String photo;

}