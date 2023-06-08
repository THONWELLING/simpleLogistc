package com.thonwelling.simpleLogistic.controllers;

import com.thonwelling.simpleLogistic.models.Client;
import com.thonwelling.simpleLogistic.repositories.ClientRepository;
import com.thonwelling.simpleLogistic.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients/v1")
public class ClientController {
  @Autowired
  ClientRepository repository;
  @Autowired
  ClientService service;
  @GetMapping
  public List<Client> getAllClients() {
    return service.getAllClients();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Client> getClientById(@PathVariable Long id) {
    return service.getClientById(id);
  }

  @GetMapping("/name")
  public List<Client> getClientByName() {
    return service.getClientByName("Margarethe Cheek");
  }

  @GetMapping("/partname")
  public List<Client> getClientByNameContaining() {
    return service.getClientByNameContaining("ga");
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Client createClient(@Valid @RequestBody Client client) {
    return service.createClient(client);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Client> updateClient(@PathVariable Long id, @Valid @RequestBody Client client) {
    if (!repository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    client.setId(id);
    client =  service.createClient(client);
    return ResponseEntity.ok(client);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
    if (!repository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    service.deleteClient(id);
    return ResponseEntity.noContent().build();
  }
}
