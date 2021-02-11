package com.sid.microservice;

import com.sid.microservice.entities.Compte;
import com.sid.microservice.entities.TypeCompte;
import com.sid.microservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.BindingType;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class MicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceApplication.class, args);

    }
    //execution de methode au demarage
    @Bean
    CommandLineRunner start(CompteRepository compteRepository){
        // methode en lamda expression
        return args -> {
            compteRepository.save(new Compte(null,Math.random()*5000,new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null,Math.random()*5000,new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null,Math.random()*5000,new Date(), TypeCompte.EPARGNE));
            compteRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }

}
