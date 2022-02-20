package com.example.Okayo.Facture.Model.Dto;

import com.example.Okayo.Facture.Model.Produit.Designation;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ClientDTO {

    @NotNull(message = "Please provide companyName")
    private String companyName;

    @NotNull(message = "Please provide postalCode")
    private String postalCode;

    @NotNull(message = "Please provide address")
    private String address;

    @NotNull(message = "Please provide city")
    private String city;

    @NotNull(message = "email is mandatory")
    private String email;

    ClientDTO() {}

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
