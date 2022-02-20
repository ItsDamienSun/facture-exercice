package com.example.Okayo.Facture.Service;

import com.example.Okayo.Facture.Model.Client;
import com.example.Okayo.Facture.Model.Produit.Designation;
import com.example.Okayo.Facture.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> findByEmail(String email) {
        return this.clientRepository.findByEmail(email);
    }

    public Client create(String companyName, String postalCode, String city, String address, String email) {
        Optional<Client> clientOptional = this.clientRepository.findByEmail(email);
        if (clientOptional.isPresent())
            return null;
        List<Designation> array = new ArrayList<>();
        Client client = new Client(companyName, postalCode, address, city, array, email);
        return this.clientRepository.save(client);
    }

    public List<Designation> addProductQte(List<Designation> designationList, String product, int qte) {
        boolean isPresent = designationList.stream().anyMatch(object -> object.getProduct().equals(product));
        if (isPresent) {
            designationList.forEach(o -> {
                if (o.getProduct().equals(product)) {
                    o.setQte(o.getQte() + qte);
                }
            });
            return designationList;
        }
        return null;
    }

    public Client setPeriodTaxe(Date startPeriod, Date endPeriod, double periodTva, String product, String email) {
        Optional<Client> optionalClient = this.clientRepository.findByEmail(email);
        if (optionalClient.isEmpty())
            return null;
        optionalClient.get().getArrayDesignation().forEach(obj -> {
            if (obj.getProduct().equals(product)) {
                obj.setPeriodTva(periodTva);
                obj.setPeriodStart(startPeriod);
                obj.setPeriodEnd(endPeriod);
            }
        });
        return this.clientRepository.save(optionalClient.get());
    }

    public Client addProduct(String clientEmail, String product, double fixedTva, double ht, int qte) {
        Optional<Client> client = this.clientRepository.findByEmail(clientEmail);
        if (client.isEmpty())
            return null;
        List<Designation> tmp;
        if ((tmp = this.addProductQte(client.get().getArrayDesignation(), product, qte)) != null) {
            client.get().setArrayDesignation(tmp);
        } else {
            Designation designation = new Designation(
                    product,
                    fixedTva,
                    ht,
                    qte
            );
            client.get().getArrayDesignation().add(designation);
        }
        return this.clientRepository.save(client.get());
    }

    public Client getClient(String email) {
        Optional<Client> clientOptional = this.clientRepository.findByEmail(email);
        if (clientOptional.isEmpty())
            return null;
        return clientOptional.get();
    }
}
