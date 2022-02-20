package com.example.Okayo.Facture.Repository;

import com.example.Okayo.Facture.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE c.email = ?1")
    Optional<Client> findByEmail(String email);
}
