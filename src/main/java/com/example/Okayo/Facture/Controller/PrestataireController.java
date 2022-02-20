package com.example.Okayo.Facture.Controller;

import com.example.Okayo.Facture.Model.Dto.PrestataireDTO;
import com.example.Okayo.Facture.Model.Prestataire;
import com.example.Okayo.Facture.Service.PrestataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping(value = "api/prestataire")
public class PrestataireController {
    private final PrestataireService prestataireService;

    @Autowired
    public PrestataireController(PrestataireService prestataireService) {
        this.prestataireService = prestataireService;
    }

    @PostMapping(value = "createPrestataire", produces = MediaType.APPLICATION_JSON_VALUE)
    public Prestataire createPrestataire(@Valid @RequestBody PrestataireDTO prestataire) {
        Prestataire prestataireTmp = this.prestataireService.create(
                prestataire.getCompanyName(),
                prestataire.getPostalCode(),
                prestataire.getAddress(),
                prestataire.getCity(),
                prestataire.getPhone(),
                prestataire.getEmail()
        );
        if (Objects.isNull(prestataireTmp)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Le prestataire existe déjà"
            );
        }
        return prestataireTmp;
    }

    @GetMapping(value = "getPrestataire", produces = MediaType.APPLICATION_JSON_VALUE)
    public Prestataire getPrestataire(@RequestParam("email") String email) {
        Prestataire prestataire = this.prestataireService.getPrestataire(email);
        if (Objects.isNull(prestataire)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Le prestataire n'existe pas"
            );
        }
        return prestataire;
    }
}
