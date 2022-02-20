package com.example.Okayo.Facture.Model;

import com.example.Okayo.Facture.Model.Produit.Designation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String postalCode;

    private String address;

    private String city;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Designation> arrayDesignation;

    private String email;

    public Client() {}

    public Client(String companyName, String postalCode, String address, String city, List<Designation> arrayDesignation, String email) {
        this.companyName = companyName;
        this.postalCode = postalCode;
        this.address = address;
        this.city = city;
        this.arrayDesignation = arrayDesignation;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Designation> getArrayDesignation() {
        return arrayDesignation;
    }

    public void setArrayDesignation(List<Designation> arrayDesignation) {
        this.arrayDesignation = arrayDesignation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
