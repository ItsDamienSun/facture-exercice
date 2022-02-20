package com.example.Okayo.Facture.Controller;

import com.example.Okayo.Facture.Model.Client;
import com.example.Okayo.Facture.Model.Dto.ClientDTO;
import com.example.Okayo.Facture.Model.Produit.Dto.DesignationDTO;
import com.example.Okayo.Facture.Model.Produit.Dto.PeriodTaxeDTO;
import com.example.Okayo.Facture.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping(value = "api/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "createClient", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client createClient(@Valid @RequestBody ClientDTO client) {
        Client clientTmp = this.clientService.create(
                client.getCompanyName(),
                client.getPostalCode(),
                client.getCity(),
                client.getAddress(),
                client.getEmail()
        );
        if (Objects.isNull(clientTmp)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Client déjà existant"
            );
        }
        return clientTmp;
    }

    @PostMapping(value = "addClientProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client addProduct(@Valid @RequestBody DesignationDTO designation) {
        Client client = this.clientService.addProduct(
                designation.getEmail(),
                designation.getProduct(),
                designation.getFixedTva(),
                designation.getHt(),
                designation.getQte()
        );
        if (Objects.isNull(client)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Le client n'existe pas"
            );
        }
        return client;
    }

    @PostMapping(value = "setPeriodTaxe", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client setPeriodTaxe(@Valid @RequestBody PeriodTaxeDTO periodTaxe) {
        Client client = this.clientService.setPeriodTaxe(
                periodTaxe.getStartPeriod(),
                periodTaxe.getEndPeriod(),
                periodTaxe.getPeriodTva(),
                periodTaxe.getProduct(),
                periodTaxe.getEmail()
        );
        if (Objects.isNull(client)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Le client n'existe pas"
            );
        }
        return client;
    }

    @GetMapping(value = "getClient", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client getClient(@RequestParam("email") String email) {
        Client client = this.clientService.getClient(email);
        if (Objects.isNull(client)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Le client n'existe pas"
            );
        }
        return client;
    }
}
