package com.example.Okayo.Facture.Model.Facture;

import com.example.Okayo.Facture.Model.Produit.Designation;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date facturationDate;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Emetteur emetteur;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Destinataire destinataire;

    private double ttc;

    Facture() {}

    public Facture(Emetteur emetteur, Destinataire destinataire, double ttc) {
        this.facturationDate = new Date();
        this.emetteur = emetteur;
        this.destinataire = destinataire;
        this.ttc = ttc;
    }

    public Long getId() {
        return id;
    }

    public Date getFacturationDate() {
        return facturationDate;
    }

    public Emetteur getEmetteur() {
        return emetteur;
    }

    public Destinataire getDestinataire() {
        return destinataire;
    }

    public double getTtc() {
        return ttc;
    }
}
