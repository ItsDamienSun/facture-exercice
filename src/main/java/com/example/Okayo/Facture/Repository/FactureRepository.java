package com.example.Okayo.Facture.Repository;

import com.example.Okayo.Facture.Model.Client;
import com.example.Okayo.Facture.Model.Facture.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
    @Query("SELECT c FROM Facture c WHERE c.facturationDate = ?1")
    Optional<Client> findFactureByEmail(Date date);
}
