package com.thonwelling.simpleLogistic.repositories;

import com.thonwelling.simpleLogistic.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
  List<Client> findByName(String name);
  List<Client> findByNameContaining(String name);

}