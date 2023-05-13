package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Classe;
import tn.esprit.demo.entities.Utilisateur;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer> {
}
