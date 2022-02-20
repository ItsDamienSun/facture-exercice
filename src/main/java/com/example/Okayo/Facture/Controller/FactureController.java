package com.example.Okayo.Facture.Controller;

import com.example.Okayo.Facture.Model.Client;
import com.example.Okayo.Facture.Model.Dto.FactureDTO;
import com.example.Okayo.Facture.Model.Facture.Emetteur;
import com.example.Okayo.Facture.Model.Facture.Facture;
import com.example.Okayo.Facture.Model.Prestataire;
import com.example.Okayo.Facture.Service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("api/facture/")
public class FactureController {
    private final FactureService factureService;

    @Autowired
    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @PostMapping(value = "makeFacture", produces = MediaType.APPLICATION_JSON_VALUE)
    public Facture createFacture(@Valid @RequestBody FactureDTO facture) {
        Facture factureTmp = this.factureService.create(
                facture.getClientEmail(),
                facture.getPrestataireEmail()
        );
        if (Objects.isNull(factureTmp)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Le prestataire ou le client n'existent pas"
            );
        }
        return factureTmp;
    }

    @GetMapping(value = "getFacture", produces = MediaType.APPLICATION_JSON_VALUE)
    public Facture getClient(@RequestParam("factureId") Long factureId) {
        Facture facture = this.factureService.getFacture(factureId);
        if (Objects.isNull(facture)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La facture n'existe pas"
            );
        }
        return facture;
    }
}
