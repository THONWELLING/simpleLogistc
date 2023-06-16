package com.thonwelling.simpleLogistic.controllers;

import com.thonwelling.simpleLogistic.models.Delivery;
import com.thonwelling.simpleLogistic.models.dto.DeliveryDTO;
import com.thonwelling.simpleLogistic.models.dto.RecipientDTO;
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
  public ResponseEntity<DeliveryDTO> getDelyveryById(@PathVariable Long id) {
    return deliveryRepository.findById(id).map(delivery -> {
          DeliveryDTO deliveryDTO = new DeliveryDTO();
          deliveryDTO.setId(delivery.getId());
          deliveryDTO.setClientName(delivery.getClient().getName());
          deliveryDTO.setRecipient(new RecipientDTO());
          deliveryDTO.getRecipient().setName(delivery.getRecipient().getName());
          deliveryDTO.getRecipient().setStreet(delivery.getRecipient().getStreet());
          deliveryDTO.getRecipient().setNumber(delivery.getRecipient().getNumber());
          deliveryDTO.getRecipient().setComplement(delivery.getRecipient().getComplement());
          deliveryDTO.getRecipient().setNeiborhood(delivery.getRecipient().getNeighborhood());
          deliveryDTO.setTax(delivery.getTax());
          deliveryDTO.setDeliveryStatus(delivery.getDeliveryStatus());
          deliveryDTO.setOrderDate(delivery.getOrderDate());
          deliveryDTO.setCompletionDate(delivery.getCompletionDate());

          return ResponseEntity.ok(deliveryDTO);
        })
        .orElse(ResponseEntity.notFound().build());
  }
}