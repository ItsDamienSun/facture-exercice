package com.example.Okayo.Facture.Model.Produit;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

;import java.util.Date;

@Entity
@Table(name = "DESIGNATION")
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private double fixedTva;

    private double periodTva;

    private Date periodStart;

    private Date periodEnd;

    private double ht;

    private int qte;

    public Designation() {}

    public Designation(String product, double fixedTva, double ht, int qte) {
        this.product = product;
        this.fixedTva = fixedTva;
        this.ht = ht;
        this.qte = qte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getFixedTva() {
        return fixedTva;
    }

    public void setFixedTva(double fixedTva) {
        this.fixedTva = fixedTva;
    }

    public double getPeriodTva() {
        return periodTva;
    }

    public void setPeriodTva(double periodTva) {
        this.periodTva = periodTva;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public double getHt() {
        return ht;
    }

    public void setHt(double ht) {
        this.ht = ht;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
