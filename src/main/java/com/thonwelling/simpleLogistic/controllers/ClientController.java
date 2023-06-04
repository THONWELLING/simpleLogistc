package com.thonwelling.simpleLogistic.controllers;

import com.thonwelling.simpleLogistic.models.Client;
import com.thonwelling.simpleLogistic.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients/v1")
public class ClientController {
  @Autowired
  ClientRepository repository;
  @GetMapping
  public List<Client> getAllClients() {
    return repository.findAll();
  }
  @GetMapping("/{id}")
  public ResponseEntity<Client> getClientById(@PathVariable Long id) {
    return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/name")
  public List<Client> getClientByName() {
    return repository.findByName("Margarethe Cheek");
  }
  @GetMapping("/partname")
  public List<Client> getClientByNameContaining() {
    return repository.findByNameContaining("ga");
  }
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Client createClient(@RequestBody Client client) {
    return repository.save(client);
  }
  @PutMapping("/{id}")
  public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
    if (!repository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    client.setId(id);
    client =  repository.save(client);
    return ResponseEntity.ok(client);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
    if (!repository.existsById(id)) {
      return ResponseEntity.notFound().build();
    }
    repository.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
