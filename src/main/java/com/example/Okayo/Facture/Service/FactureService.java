package com.example.Okayo.Facture.Service;

import com.example.Okayo.Facture.Model.Client;
import com.example.Okayo.Facture.Model.Facture.Destinataire;
import com.example.Okayo.Facture.Model.Facture.Emetteur;
import com.example.Okayo.Facture.Model.Facture.Facture;
import com.example.Okayo.Facture.Model.Prestataire;
import com.example.Okayo.Facture.Model.Produit.FactureDesignation;
import com.example.Okayo.Facture.Repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class FactureService {
    private final FactureRepository factureRepository;
    private final ClientService clientService;
    private final PrestataireService prestataireService;
    private final EmetteurService emetteurService;
    private final DestinataireService destinataireService;

    @Autowired
    public FactureService(FactureRepository factureRepository, ClientService clientService, PrestataireService prestataireService, EmetteurService emetteurService, DestinataireService destinataireService) {
        this.factureRepository = factureRepository;
        this.clientService = clientService;
        this.prestataireService = prestataireService;
        this.emetteurService = emetteurService;
        this.destinataireService = destinataireService;
    }

    public boolean checkPeriodDate(Date endPeriod, Date startPeriod) {
        Date dateNow = new Date();
        if (Objects.isNull(endPeriod) || Objects.isNull(startPeriod)) {
            return false;
        }
        if (dateNow.after(startPeriod) && !dateNow.after(endPeriod)) {
            return true;
        }
        return false;
    }

    public double calculFacture(List<FactureDesignation> designationList) {
        AtomicReference<Double> ttc = new AtomicReference<>((double) 0);
        AtomicReference<Double> tva = new AtomicReference<>((double) 0);
        AtomicBoolean check = new AtomicBoolean(false);
        designationList.forEach(o -> {
            check.set(this.checkPeriodDate(o.getPeriodEnd(), o.getPeriodStart()));
            if (check.get())
                tva.set(o.getPeriodTva());
            else
                tva.set(o.getFixedTva());
            ttc.updateAndGet(v -> (v + ((o.getHt() * o.getQte()) * (1 + (tva.get() / 100)))));
        });
        return ttc.get();
    }

    public Facture getFacture(Long factureId) {
        Optional<Facture> factureOptional = this.factureRepository.findById(factureId);
        if (factureOptional.isEmpty())
            return null;
        return factureOptional.get();
    }

    public Facture create(String clientEmail, String prestataireEmail) {
        double ttc;
        Optional<Client> client = this.clientService.findByEmail(clientEmail);
        if (client.isEmpty())
            return null;
        Destinataire destinataire = this.destinataireService.create(client.get());
        destinataire.setArrayDesignation(this.destinataireService.copyDesignationToEmetteur(client.get().getArrayDesignation()));
        Optional<Prestataire> prestataire = this.prestataireService.findByEmail(prestataireEmail);
        if (prestataire.isEmpty())
            return null;
        Emetteur emetteur = this.emetteurService.create(prestataire.get());
        ttc = this.calculFacture(destinataire.getArrayDesignation());
        Facture facture = new Facture(emetteur, destinataire, ttc);
        return this.factureRepository.save(facture);
    }
}
