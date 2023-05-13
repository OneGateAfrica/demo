package tn.esprit.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.*;
import tn.esprit.demo.services.IAppService;

@RestController
@RequiredArgsConstructor
public class AppController {
    private final IAppService iAppService;

    @PostMapping("/user/add")
    public Utilisateur save(@RequestBody Utilisateur entity) {
        return iAppService.ajouterUtilisateur(entity);
    }

    @PostMapping("/classe/add")
    public Classe ajouterClasse(@RequestBody Classe c) {
        return iAppService.ajouterClasse(c);
    }
    @PostMapping("ajouterCourCLasseRoom/{codeClasse}")
    public CourClassRoom ajouterCourCLasseRoom(@RequestBody CourClassRoom c,@PathVariable Integer codeClasse) {
        return iAppService.ajouterCourCLasseRoom(c,codeClasse);
    }
    @PutMapping("affecterUtilisateurClasse/{idUser}/{codeClasse}")
    public void affecterUtilisateurClasse(@PathVariable Integer idUser,@PathVariable Integer codeClasse) {
        iAppService.affecterUtilisateurClasse(idUser, codeClasse);
    }
@GetMapping("/nbUsers/{nv}")
    public Integer nbUtilisateurParNiveau(@PathVariable Niveau nv) {
        return iAppService.nbUtilisateurParNiveau(nv);
    }
    @PutMapping("/desaffecter/{idCours}")
    public void desaffecterCoursClassRoom(@PathVariable Integer idCours) {
        iAppService.desaffecterCoursClassRoom(idCours);
    }

    @GetMapping("/nbhoures/{specialite}/{nv}")
    public Integer nbHouresParSpecEtNiveau(@PathVariable Specialite specialite,@PathVariable Niveau nv) {
        return iAppService.nbHouresParSpecEtNiveau(specialite,nv);
    }
}
