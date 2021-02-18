package com.sid.microservice.repositories;

import com.sid.microservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//activation de spring data
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {
}
