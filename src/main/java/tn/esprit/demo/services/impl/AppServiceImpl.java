package tn.esprit.demo.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Magasin;
import tn.esprit.demo.entities.Produit;
import tn.esprit.demo.repositories.MagasinRepository;
import tn.esprit.demo.repositories.ProduitRepository;
import tn.esprit.demo.services.IAppService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppServiceImpl implements IAppService {

    private final MagasinRepository magasinRepository;

    private final ProduitRepository produitRepository;


    @Override
    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Magasin addMagasin(Magasin magasin) {
        return magasinRepository.save(magasin);
    }

    @Override
    public Magasin updateMagasin(Magasin magasin) {
        return magasinRepository.save(magasin);
    }

    @Override
    public void deleteMagasin(Long id) {
        magasinRepository.deleteById(id);
    }

    @Override
    public List<Magasin> getAllMagasins() {
        return magasinRepository.findAll();
    }
}
