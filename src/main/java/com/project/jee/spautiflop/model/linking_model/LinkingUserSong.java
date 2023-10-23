package com.project.jee.spautiflop.model.linking_model;

import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.Song;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "linking_user_song")
public class LinkingUserSong {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;


}