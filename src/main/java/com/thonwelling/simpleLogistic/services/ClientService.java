package com.thonwelling.simpleLogistic.services;

import com.thonwelling.simpleLogistic.exception.BusinesException;
import com.thonwelling.simpleLogistic.models.Client;
import com.thonwelling.simpleLogistic.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
  @Autowired
  ClientRepository repository;

  public List<Client> getClientByNameContaining(String name) {
    return repository.findByNameContaining(name);
  }

  public List<Client> getClientByName(String name) {
    return repository.findByName(name);
  }
  public ResponseEntity<Client> getClientById(Long id) {
    return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }
  public List<Client> getAllClients() {
    return repository.findAll();
  }
  @Transactional
  public Client createClient(Client client) {
    boolean usedEmail = repository.findByEmail(client.getEmail())
        .stream()
        .anyMatch(persistedClient -> !persistedClient.equals(client));
    if (usedEmail) {
        throw  new BusinesException("Already Exists a Client With This Email");
    }
    return repository.save(client);
  }

  @Transactional
  public void deleteClient(Long id) {
    repository.deleteById(id);
  }
}
