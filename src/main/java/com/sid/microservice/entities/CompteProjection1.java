package com.sid.microservice.entities;

import org.springframework.data.rest.core.config.Projection;

//ressource seulement avec le sold
@Projection(name="sold",types = Compte.class)
public interface CompteProjection1 {
    public double getSolde();
}
