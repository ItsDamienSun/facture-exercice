package com.example.Okayo.Facture.Service;

import com.example.Okayo.Facture.Model.Client;
import com.example.Okayo.Facture.Model.Facture.Destinataire;
import com.example.Okayo.Facture.Model.Produit.Designation;
import com.example.Okayo.Facture.Model.Produit.FactureDesignation;
import com.example.Okayo.Facture.Repository.DestinataireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DestinataireService {
    private final DestinataireRepository destinataireRepository;

    @Autowired
    public DestinataireService(DestinataireRepository destinataireRepository) {
        this.destinataireRepository = destinataireRepository;
    }

    public Destinataire create(Client client) {
        Destinataire destinataire = new Destinataire(
                client.getCompanyName(),
                client.getPostalCode(),
                client.getAddress(),
                client.getCity()
        );
        return destinataire;
    }

    public List<FactureDesignation> copyDesignationToEmetteur(List<Designation> designationList) {
        List<FactureDesignation> factureDesignationList = new ArrayList<>();
        designationList.forEach(obj -> {
            FactureDesignation factureDesignation = new FactureDesignation(
                    obj.getProduct(),
                    obj.getFixedTva(),
                    obj.getHt(),
                    obj.getQte()
            );
            factureDesignationList.add(factureDesignation);
        });
        return factureDesignationList;
    }
}
