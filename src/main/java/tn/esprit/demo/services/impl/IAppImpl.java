package tn.esprit.demo.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.demo.entities.*;
import tn.esprit.demo.repositories.ClasseRepository;
import tn.esprit.demo.repositories.CourClasseRoomRepository;
import tn.esprit.demo.repositories.UtilisateurRepository;
import tn.esprit.demo.services.IAppService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IAppImpl implements IAppService {

    private final UtilisateurRepository utilisateurRepository;
    private final ClasseRepository classeRepository;
    private final CourClasseRoomRepository courClasseRoomRepository;
    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur entity) {
        return utilisateurRepository.save(entity);
    }

    @Override
    public Classe ajouterClasse(Classe c) {
        return classeRepository.save(c);
    }

    @Override
    public CourClassRoom ajouterCourCLasseRoom(CourClassRoom c, Integer codeClasse) {
        Classe classe = classeRepository.findById(codeClasse).orElse(null);
        Assert.notNull(classe , "classe est null");
        c.setClasse(classe);
        return courClasseRoomRepository.save(c);
    }

    @Override
    @Transactional
    public void affecterUtilisateurClasse(Integer idUser, Integer codeClasse) {
        Utilisateur utilisateur = utilisateurRepository.findById(idUser).orElse(null);
        Assert.notNull(utilisateur, "l'utilisateur est null");
        Classe classe = classeRepository.findById(codeClasse).orElse(null);
        Assert.notNull(classe, "le classe est null");

        utilisateur.setClasse(classe);


    }

    @Override
    public Integer nbUtilisateurParNiveau(Niveau nv) {
        return utilisateurRepository.countByClasseNiveau(nv);
    }

    @Override
    @Transactional
    public void desaffecterCoursClassRoom(Integer idCours) {
        CourClassRoom courClassRoom = courClasseRoomRepository.findByNom("Plantes").orElse(null);
        Assert.notNull(courClassRoom, "le coursClasseRoom est null");
        Classe classe = classeRepository.findById(idCours).orElse(null);
        Assert.notNull(classe, "le cours est null");
        if (courClassRoom.getClasse().getId().equals(classe.getId())){
            courClassRoom.setClasse(null);
        }

    }

    @Override
    public Integer nbHouresParSpecEtNiveau(Specialite specialite, Niveau nv) {
       List<CourClassRoom> courClassRooms =  courClasseRoomRepository.findBySpecialiteAndClasse_Niveau(specialite,nv);
       Integer nbh = 0;
       for(CourClassRoom cour : courClassRooms){
           log.info("cour {} :" , cour.getNbHeure());
           nbh+= cour.getNbHeure();
       }
        return nbh;
    }

    @Scheduled(fixedDelay = 60000)
    void archiverCoursClassRoom(){
       List<CourClassRoom> classRooms = courClasseRoomRepository.findAll();
       classRooms.forEach(c -> {

           c.setArchive(true);
           courClasseRoomRepository.save(c);
           log.info("courClassRoom {} est archivé ", c.getNom());
       });
    }


}
