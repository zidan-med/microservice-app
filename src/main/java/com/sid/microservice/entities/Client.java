package com.sid.microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //LAZZY:quand en demande de charger un client il ne charger pas aussi les comptes liee a ce client
    @OneToMany(mappedBy = "client")
    private Collection<Compte> comptes;
}
