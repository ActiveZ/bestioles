package fr.diginamic.bestioles.entities;

import fr.diginamic.bestioles.enums.Sex;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(length = 50)
    private String color;

    @Column(length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToOne
    private Species species;

}
