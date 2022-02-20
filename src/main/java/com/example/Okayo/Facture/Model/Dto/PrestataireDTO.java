package com.example.Okayo.Facture.Model.Dto;

import com.example.Okayo.Facture.Model.Prestataire;

import javax.validation.constraints.NotNull;

public class PrestataireDTO {

    @NotNull(message = "Please provide companyName")
    private String companyName;

    @NotNull(message = "Please provide postalCode")
    private String postalCode;

    @NotNull(message = "Please provide address")
    private String address;

    @NotNull(message = "Please provide city")
    private String city;

    @NotNull(message = "Please provide phone")
    private String phone;

    @NotNull(message = "email is mandatory")
    private String email;

    PrestataireDTO() {}

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

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
