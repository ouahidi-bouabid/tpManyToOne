package com.ouahidi.tpmanytoone;

import com.ouahidi.tpmanytoone.entities.Client;
import com.ouahidi.tpmanytoone.entities.Commande;
import com.ouahidi.tpmanytoone.repositories.ClientRepository;
import com.ouahidi.tpmanytoone.repositories.CommandeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpManyToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpManyToOneApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ClientRepository clientRepository, CommandeRepository commandeRepository)
	{ return args -> {
		Client cl1 = Client.builder()
				.nom("Mohammed")
				.build();
		clientRepository.save(cl1);

		Client cl2= Client.builder()
				.nom("Aicha")
				.build();
		clientRepository.save(cl2);

		Client cl3 = Client.builder()
				.nom("Amine")
				.build();
		clientRepository.save(cl3);

Commande cm1 =  Commande.builder()
		.montant(9000.0)
		.client(cl1)

		.build();
commandeRepository.save(cm1);

		Commande cm2 =  Commande.builder()
				.montant(7000.0)
				.client(cl1)

				.build();
		commandeRepository.save(cm2);

		Commande cm3 =  Commande.builder()
				.montant(8000.0)
				.client(cl2)

				.build();
		commandeRepository.save(cm3);






	};}


}
