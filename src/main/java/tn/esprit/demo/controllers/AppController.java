package tn.esprit.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Magasin;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.services.IAppService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppController {
    private final IAppService iAppService;

    @PostMapping("addProduit")
    public Produit addProduit(@RequestBody Produit produit) {
        return iAppService.addProduit(produit);
    }
    @PutMapping("updateProduit")

    public Produit updateProduit(@RequestBody Produit produit) {
        return iAppService.updateProduit(produit);
    }
    @DeleteMapping("deleteProduit/{id}")
    public void deleteProduit(@PathVariable Long id) {
    iAppService.deleteProduit(id);
    }
    @GetMapping("getProduits")
    public List<Produit> getAllProduits() {
        return iAppService.getAllProduits();
    }

    @PostMapping("addMagasin")
    public Magasin addMagasin(@RequestBody Magasin magasin) {
        return iAppService.addMagasin(magasin);
    }

    @PutMapping("updateMagasin")
    public Magasin updateMagasin(Magasin magasin) {
        return iAppService.updateMagasin(magasin);
    }


    @DeleteMapping("deleteMagasin/{id}")
    public void deleteMagasin(Long id) {
    iAppService.deleteMagasin(id);
    }
    @GetMapping("getMagasins")
    public List<Magasin> getAllMagasins() {
        return iAppService.getAllMagasins();
    }
}
