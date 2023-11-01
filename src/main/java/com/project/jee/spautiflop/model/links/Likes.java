package com.project.jee.spautiflop.model.links;

import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.Song;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "likes")
public class Likes {

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne
    @JoinColumn(name = "local_user_id")
    private LocalUser localUser;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

}