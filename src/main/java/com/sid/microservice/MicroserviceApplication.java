package com.sid.microservice;

import com.sid.microservice.entities.Client;
import com.sid.microservice.entities.Compte;
import com.sid.microservice.entities.TypeCompte;
import com.sid.microservice.repositories.ClientRepository;
import com.sid.microservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

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
    CommandLineRunner start(CompteRepository compteRepository,
                            RepositoryRestConfiguration restConfiguration,
                            ClientRepository clientRepository){
        // methode en lamda expression
        return args -> {
            //pour exposer le id
            restConfiguration.exposeIdsFor(Compte.class);
            Client c1=clientRepository.save(new Client(null,"zidan",null));
            Client c2=clientRepository.save(new Client(null,"saad",null));
            Client c3=clientRepository.save(new Client(null,"meryam",null));

            compteRepository.save(new Compte(null,Math.random()*5000,new Date(), TypeCompte.EPARGNE,c1));
            compteRepository.save(new Compte(null,Math.random()*5000,new Date(), TypeCompte.COURANT,c2));
            compteRepository.save(new Compte(null,Math.random()*5000,new Date(), TypeCompte.EPARGNE,c3));
            compteRepository.findAll().forEach(c ->{
                System.out.println(c);
            });
        };
    }

}
