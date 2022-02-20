package com.example.Okayo.Facture.Repository;

import com.example.Okayo.Facture.Model.Prestataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrestataireRepository extends JpaRepository<Prestataire, Long> {
    @Query("SELECT c FROM Prestataire c WHERE c.email = ?1")
    Optional<Prestataire> findByEmail(String email);
}
