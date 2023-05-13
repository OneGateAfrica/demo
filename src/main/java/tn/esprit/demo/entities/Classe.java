package tn.esprit.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    @Enumerated(EnumType.STRING)
    Niveau niveau;
    @JsonIgnore
    @OneToMany(mappedBy = "classe")
    List<CourClassRoom> courClassRoom;
}
