package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Classe;
import tn.esprit.demo.entities.CourClassRoom;
import tn.esprit.demo.entities.Niveau;
import tn.esprit.demo.entities.Specialite;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourClasseRoomRepository extends JpaRepository<CourClassRoom, Integer> {
    Optional<CourClassRoom> findByNom(String nom);

    List<CourClassRoom> findBySpecialiteAndClasse_Niveau(Specialite specialite , Niveau nv);

}
