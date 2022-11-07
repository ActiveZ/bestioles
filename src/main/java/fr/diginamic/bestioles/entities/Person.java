package fr.diginamic.bestioles.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    @Max(120)
    @Min(0)
    private Integer age;

    @Column(length = 50)
    @NotEmpty
    @Size(max = 50)
    private String firstname;

    @Column(length = 50)
    @NotEmpty
    @Size(max = 50)
    private String lastname;
}


