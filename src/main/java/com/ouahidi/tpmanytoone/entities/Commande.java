package com.ouahidi.tpmanytoone.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Commande {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCommande;
    private Double montant;

    // Sans table
    @ManyToOne(cascade = CascadeType.MERGE) // Car sinon la table de Client sera fermée
    @JoinColumn(name="IdClient")
    private Client client;

    //On peut faire ce lien avec un table d'association aussi comme suit
/*
@ManyToOne
    // Premiere solution et c'est mieux @JoinColumn(name="idClient") ou
	@JoinTable (name="Commande_Client_Association",
	            joinColumns=@JoinColumn(name="IdCommande"),
	             inverseJoinColumns=@JoinColumn(name="IdClient"))

	private Client client;
   */

}
