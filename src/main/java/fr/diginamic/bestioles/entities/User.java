package fr.diginamic.bestioles.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String userName;

    @Column(name = "password_hash", length = 60, nullable = false)
    private String passwordHash;

    @ManyToMany
    private Set<Authority> authorities = new HashSet<>();
}
