package fr.diginamic.bestioles.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Authority {
    @Id
    @Column(name = "name", nullable = false)
    private String name;

}
