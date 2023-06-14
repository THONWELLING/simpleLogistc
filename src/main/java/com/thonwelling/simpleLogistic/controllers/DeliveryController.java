package com.thonwelling.simpleLogistic.controllers;

import com.thonwelling.simpleLogistic.models.Delivery;
import com.thonwelling.simpleLogistic.repositories.DeliveryRepository;
import com.thonwelling.simpleLogistic.services.DeliveryOrderRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery/v1")
public class DeliveryController {

  @Autowired
  DeliveryOrderRequestService deliveryService;
  @Autowired
  DeliveryRepository deliveryRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Delivery requestDelivery(@Valid @RequestBody Delivery delivery){
    return deliveryService.requestDelivery(delivery);
  }

  @GetMapping
  public List<Delivery> getDeliveryList() {
    return deliveryRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Delivery> getDelyveryById(@PathVariable Long id) {
    return deliveryRepository.findById(id).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }
}