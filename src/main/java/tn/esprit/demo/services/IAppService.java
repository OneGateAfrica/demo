package tn.esprit.demo.services;

import tn.esprit.demo.entities.*;

public interface IAppService {
    Utilisateur ajouterUtilisateur(Utilisateur entity);

    Classe ajouterClasse(Classe c);
    CourClassRoom ajouterCourCLasseRoom(CourClassRoom c , Integer codeClasse);
    void affecterUtilisateurClasse(Integer idUser , Integer codeClasse);

    Integer nbUtilisateurParNiveau(Niveau nv);

    void desaffecterCoursClassRoom(Integer idCours);

     Integer nbHouresParSpecEtNiveau(Specialite specialite , Niveau nv);
}
