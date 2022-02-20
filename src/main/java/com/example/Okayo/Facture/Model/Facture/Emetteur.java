package com.example.Okayo.Facture.Model.Facture;

import javax.persistence.*;

@Entity
@Table
public class Emetteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String postalCode;

    private String address;

    private String city;

    private String email;

    Emetteur() {}

    public Emetteur(String companyName, String postalCode, String address, String city, String email) {
        this.companyName = companyName;
        this.postalCode = postalCode;
        this.address = address;
        this.city = city;
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }
}
