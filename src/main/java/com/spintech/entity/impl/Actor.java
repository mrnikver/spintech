package com.spintech.entity.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Accessors(chain = true)
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "\"actor\"")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    @ManyToMany(mappedBy = "actors")
    private Set<Show> shows = new HashSet<>();

    @ManyToMany(mappedBy = "favouriteActors")
    private Set<User> likedBy = new HashSet<>();
}
