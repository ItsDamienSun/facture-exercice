package com.example.Okayo.Facture.Service;

import com.example.Okayo.Facture.Model.Client;
import com.example.Okayo.Facture.Model.Facture.Destinataire;
import com.example.Okayo.Facture.Model.Facture.Emetteur;
import com.example.Okayo.Facture.Model.Prestataire;
import com.example.Okayo.Facture.Repository.EmetteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmetteurService {
    private final EmetteurRepository emetteurRepository;

    @Autowired
    public EmetteurService(EmetteurRepository emetteurRepository) {
        this.emetteurRepository = emetteurRepository;
    }

    public Emetteur create(Prestataire prestataire) {
        Emetteur emetteur = new Emetteur(
                prestataire.getCompanyName(),
                prestataire.getPostalCode(),
                prestataire.getAddress(),
                prestataire.getCity(),
                prestataire.getEmail()
        );
        return emetteur;
    }
}
