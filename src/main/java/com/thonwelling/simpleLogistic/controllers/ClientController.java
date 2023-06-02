package com.thonwelling.simpleLogistic.controllers;

import com.thonwelling.simpleLogistic.models.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clients/v1")
public class ClientController {

  @GetMapping
  public List<Client> getAllClients() {
    Client client = new Client();
    client.setId(1L);
    client.setName("ThonWelling2");
    client.setEmail("thonwelling@gmail.com");
    client.setTelefone("(11) 9 9759-4156");

    Client client1 = new Client();
    client1.setId(2L);
    client1.setName("ThonWelling");
    client1.setEmail("thonwelling@gmail.com");
    client1.setTelefone("(11) 9 9759-4156");

    return Arrays.asList(client, client1);
  }
}
