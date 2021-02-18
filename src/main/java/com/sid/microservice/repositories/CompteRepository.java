package com.sid.microservice.repositories;

import com.sid.microservice.entities.Compte;
import com.sid.microservice.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

//activation de spring data
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {
    //spring data Rest chercher par un type(recherche specifique)
    @RestResource(path="byType")
    public List<Compte> findByType(@Param("t")TypeCompte type);
}
