package com.spintech.entity;

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
@Table(name = "\"show\"")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 1000)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "show_actor",
            joinColumns = {@JoinColumn(name = "show_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id", referencedColumnName = "id")}
    )
    Set<Actor> actors = new HashSet<>();

    @ManyToMany(mappedBy = "watchedShows")
    private Set<User> watchedBy = new HashSet<>();
}
