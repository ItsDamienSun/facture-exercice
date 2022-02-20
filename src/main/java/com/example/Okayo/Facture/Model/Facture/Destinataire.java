package com.example.Okayo.Facture.Model.Facture;

import com.example.Okayo.Facture.Model.Produit.Designation;
import com.example.Okayo.Facture.Model.Produit.FactureDesignation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Destinataire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String postalCode;

    private String address;

    private String city;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FactureDesignation> arrayDesignation;

    Destinataire() {}

    public Destinataire(String companyName, String postalCode, String address, String city) {
        this.companyName = companyName;
        this.postalCode = postalCode;
        this.address = address;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAdress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public List<FactureDesignation> getArrayDesignation() {
        return arrayDesignation;
    }

    public void setArrayDesignation(List<FactureDesignation> arrayDesignation) {
        this.arrayDesignation = arrayDesignation;
    }
}
