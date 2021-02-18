package com.sid.microservice.entities;

import org.springframework.data.rest.core.config.Projection;

//ressource seulement avec le sold+type
@Projection(name="mobile",types = Compte.class)
public interface CompteProjection2 {
    public double getSolde();
    public TypeCompte geType();
}
