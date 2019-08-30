package com.github.pedrobacchini.springdatarest.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"group\"")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PRIVATE) //For hibernate
public final class Group implements Identifiable<Long>, Serializable {

    private static final long serialVersionUID = 4061216109665381170L;

    @Id
    @Getter
    @GeneratedValue(generator = "SequencePerEntityGenerator")
    private Long id;

    @Getter
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "group")
    private Set<User> users = new HashSet<>();

    public Group(final String name) { this.name = name; }

    public void addUser(final User user) {
        users.add(user);
        user.setGroup(this);
    }

    public void removeUser(final User user) {
        users.remove(user);
        user.setGroup(null);
    }

    public Set<User> getUsers() { return Collections.unmodifiableSet(this.users); }
}

