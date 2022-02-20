package com.example.Okayo.Facture.Model.Produit.Dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class PeriodTaxeDTO {

    @NotNull(message = "email is mandatory")
    private String email;

    @NotNull(message = "Please provide the product name")
    private String product;

    @NotNull(message = "Start date is mandatory")
    private Date startPeriod;

    @NotNull(message = "End date is mandatory")
    private Date endPeriod;

    @NotNull(message = "Please provide tva value")
    private double periodTva;

    PeriodTaxeDTO() {}

    public String getEmail() {
        return email;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Date startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Date getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Date endPeriod) {
        this.endPeriod = endPeriod;
    }

    public double getPeriodTva() {
        return periodTva;
    }

    public void setPeriodTva(double periodTva) {
        this.periodTva = periodTva;
    }
}
