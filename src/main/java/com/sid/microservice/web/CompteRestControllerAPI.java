package com.sid.microservice.web;

import com.sid.microservice.entities.Compte;
import com.sid.microservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

//Rest controller API
//@RestController
//url(path) de base
@RequestMapping("/banque")
public class CompteRestControllerAPI {
    //injection dependence
    @Autowired
    private CompteRepository compteRepository;
    @GetMapping(path = "/comptes",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }
    @GetMapping("/comptes/{id}")
    public Compte getOne(@PathVariable(value = "id") Long id){

        return compteRepository.findById(id).get();
    }
    @PostMapping("/comptes")
    public Compte save(@RequestBody Compte compte){

        return compteRepository.save(compte);
    }
    @PutMapping("/comptes/{id}")
    public Compte update(@RequestBody Compte compte,@PathVariable(value = "id") Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }
    @DeleteMapping("/comptes/{id}")
    public void delete(@PathVariable(value = "id") Long id){

        compteRepository.deleteById(id);
    }
}
