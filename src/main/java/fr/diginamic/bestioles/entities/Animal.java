package fr.diginamic.bestioles.entities;

import fr.diginamic.bestioles.enums.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotEmpty
    private String name;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToOne
    @NotNull
    private Species species;

}
