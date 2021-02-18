package com.sid.microservice.web;

import com.sid.microservice.entities.Compte;
import com.sid.microservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
//pour que Autowired camarche parcequ'il est une annotation spring et on est on JAXWS
@Component
//JAXWS
@WebService(seviceName = "BanqueWS")
public class CompteSoapService {
    //injection dependence
    @Autowired
    private CompteRepository compteRepository;
    @WebMethod
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }
    @WebMethod
    public Compte getOne(@WebParam(name = "id") Long id){
        return compteRepository.findById(id).get();
    }

}
