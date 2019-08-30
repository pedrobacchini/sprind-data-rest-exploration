package com.github.pedrobacchini.springdatarest.entity;

import lombok.*;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@Table(name = "\"user\"")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PRIVATE) //For hibernate
public final class User implements Identifiable<Long>, Serializable {

    private static final long serialVersionUID = -8672288038084684957L;

    @Id
    @GeneratedValue(generator = "SequencePerEntityGenerator")
    private Long id;

    @Column(length = 16, nullable = false, unique = true)
    private String username;

    @Column(name = "first_name", nullable = false)
    private String firstname;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Setter
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Group group;

    public User(final String username, final String firstname, final String lastName) {
        this.username = username;
        this.firstname = firstname;
        this.lastName = lastName;
    }
}
