package com.sid.microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;
//JAXB annotation
@XmlRootElement
//les annotations JAXB sont places sur les attributs et non pas les getters
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //LAZZY:quand en demande de charger un client il ne charger pas aussi les comptes liee a ce client
    @OneToMany(mappedBy = "client")
    //JAXB annotation
    @XmlTransient
    private Collection<Compte> comptes;
}
