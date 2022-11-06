package fr.diginamic.bestioles.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column (length = 50)
    @NotEmpty
    @Size(max = 50)
    private String commonName;

    @Column (length = 120)
    @NotEmpty
    @Size(max = 120)
    private String latinName;

}
