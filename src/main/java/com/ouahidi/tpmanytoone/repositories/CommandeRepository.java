package com.ouahidi.tpmanytoone.repositories;

import com.ouahidi.tpmanytoone.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
