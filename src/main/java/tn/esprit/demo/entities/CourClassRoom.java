package tn.esprit.demo.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Enumerated(value = EnumType.STRING)
    Specialite specialite;

    String nom;

    Integer nbHeure;

    boolean archive;

    @ManyToOne
    Classe classe;
}
