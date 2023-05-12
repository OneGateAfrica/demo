package tn.esprit.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo.entities.Magasin;

@Repository
public interface MagasinRepository extends JpaRepository<Magasin, Long> {
}
