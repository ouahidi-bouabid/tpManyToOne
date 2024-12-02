package com.ouahidi.tpmanytoone.web;

import com.ouahidi.tpmanytoone.entities.Client;
import com.ouahidi.tpmanytoone.entities.Commande;
import com.ouahidi.tpmanytoone.repositories.ClientRepository;
import com.ouahidi.tpmanytoone.repositories.CommandeRepository;


import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.beans.BeanProperty;
import java.util.List;

@RestController
public class ClientCommandeController

{
   ;
    private ClientRepository clientRepository;
    private CommandeRepository commandeRepository;

    public ClientCommandeController(ClientRepository clientRepository, CommandeRepository  commandeRepository)
                                     {
        this.clientRepository = clientRepository;
        this.commandeRepository=commandeRepository;

    }

    @GetMapping("/clients")
    public List<Client> allClients()
    { return clientRepository.findAll();}
    @GetMapping("/clients/{id}")
    public Client clientbyId(@PathVariable Long id )
    { return clientRepository.findById(id).get();}


@GetMapping("/commandes")
    public List<Commande>  allCommande()
    { return commandeRepository.findAll();}

 @GetMapping("/commandes/{id}")
public Commande commandeById(@PathVariable Long id)
{ return commandeRepository.findById(id).get();}

    @PostMapping("/clients")
public void newClient(@RequestBody Client cl)
{
    Client c =  new Client();


// faites attention à l'import, il s'agit --> import org.springframework.beans.BeanUtils
    // copie tous les attributs de cl dans c.
    BeanUtils.copyProperties(cl,c);

    // ou avec c.setNom(cl.getNom());

    clientRepository.save(c);


}
    @PostMapping("/commandes")
    public void newCommande(@RequestBody Commande cm)
    { Commande cmm = new Commande();
        BeanUtils.copyProperties(cm, cmm);
        commandeRepository.save(cmm);

    }


}
