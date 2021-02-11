package com.sid.microservice.entities.web;

import com.sid.microservice.entities.Compte;
import com.sid.microservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
//JAXRS REST API implementation(Jersey) (remplace le DispatcherSelvlet)
//pour que spring recenu les inotation JAXRS
@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
    //injection dependence
    @Autowired
    private CompteRepository compteRepository;
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getOne(@PathParam(value = "id") Long id){
        return compteRepository.findById(id).get();
    }
    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte save(Compte compte){
        return compteRepository.save(compte);
    }
    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte update(Compte compte,@PathParam(value = "id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }
    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(Compte compte,@PathParam(value = "id") Long id){
        compteRepository.deleteById(id);
    }
}
