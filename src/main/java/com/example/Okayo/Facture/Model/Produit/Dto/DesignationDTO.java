package com.example.Okayo.Facture.Model.Produit.Dto;

import javax.validation.constraints.NotNull;

public class DesignationDTO {

    @NotNull(message = "Please provide product")
    private String product;

    @NotNull(message = "Please provide fixedTva")
    private double fixedTva;

    @NotNull(message = "Please provide email")
    private String email;

    @NotNull(message = "Please provide ht")
    private double ht;

    @NotNull(message = "Please provide qte")
    private int qte;

    DesignationDTO() {}

    public String getProduct() {
        return product;
    }

    public double getFixedTva() {
        return fixedTva;
    }

    public String getEmail() {
        return email;
    }

    public double getHt() {
        return ht;
    }

    public int getQte() {
        return qte;
    }
}
