package tn.esprit.demo.services;

import tn.esprit.demo.entities.Magasin;
import tn.esprit.demo.entities.Produit;

import java.util.List;

public interface IAppService {
    Produit addProduit(Produit produit);
    Produit updateProduit(Produit produit);
    void deleteProduit(Long id);
    List<Produit> getAllProduits();

    Magasin addMagasin(Magasin magasin);
    Magasin updateMagasin(Magasin magasin);
    void deleteMagasin(Long id);

    List<Magasin> getAllMagasins();

}
