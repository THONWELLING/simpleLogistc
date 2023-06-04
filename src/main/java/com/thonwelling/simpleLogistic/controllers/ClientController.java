package com.thonwelling.simpleLogistic.controllers;

import com.thonwelling.simpleLogistic.models.Client;
import com.thonwelling.simpleLogistic.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients/v1")
public class ClientController {
  @Autowired
  ClientRepository repository;
  @GetMapping
  public List<Client> getAllClients() {
    return repository.findAll();
  }
  @GetMapping("/name")
  public List<Client> getClientByName() {
    return repository.findByName("Margarethe Cheek");
  }
  @GetMapping("/partname")
  public List<Client> getClientByNameContaining() {
    return repository.findByNameContaining("ga");
  }
}
