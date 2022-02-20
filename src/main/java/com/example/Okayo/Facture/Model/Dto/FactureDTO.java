package com.example.Okayo.Facture.Model.Dto;

import javax.validation.constraints.NotNull;

public class FactureDTO {

    @NotNull(message = "clientEmail is mandatory")
    private String clientEmail;

    @NotNull(message = "prestataireEmail is mandatory")
    private String prestataireEmail;

    void Facture() {}

    public String getClientEmail() {
        return clientEmail;
    }

    public String getPrestataireEmail() {
        return prestataireEmail;
    }
}
