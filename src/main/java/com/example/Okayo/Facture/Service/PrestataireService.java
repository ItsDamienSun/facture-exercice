package com.example.Okayo.Facture.Service;

import com.example.Okayo.Facture.Model.Prestataire;
import com.example.Okayo.Facture.Repository.PrestataireRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PrestataireService {
    private final PrestataireRepository prestataireRepository;

    public PrestataireService(PrestataireRepository prestataireRepository) {
        this.prestataireRepository = prestataireRepository;
    }

    public Optional<Prestataire> findByEmail(String email) {
        return this.prestataireRepository.findByEmail(email);
    }

    public Prestataire getPrestataire(String email) {
        Optional<Prestataire> prestataireOptional = this.prestataireRepository.findByEmail(email);
        if (prestataireOptional.isEmpty())
            return null;
        return prestataireOptional.get();
    }

    public Prestataire create(String companyName, String postalCode, String address, String city, String phone, String email) {
        Optional<Prestataire> checkPrestataire = this.prestataireRepository.findByEmail(email);
        if (checkPrestataire.isPresent())
            return null;
        Prestataire prestataire = new Prestataire(
                companyName,
                postalCode,
                address,
                city,
                phone,
                email
        );
        return this.prestataireRepository.save(prestataire);
    }
}
