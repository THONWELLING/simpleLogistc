package com.thonwelling.simpleLogistic.controllers;

import com.thonwelling.simpleLogistic.models.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clients/v1")
public class ClientController {

  @PersistenceContext
  private EntityManager manager;
  @GetMapping
  public List<Client> getAllClients() {
    return manager.createQuery("from Client", Client.class).getResultList();
  }
}
