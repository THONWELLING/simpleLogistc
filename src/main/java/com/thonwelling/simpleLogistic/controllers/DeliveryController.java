package com.thonwelling.simpleLogistic.controllers;

import com.thonwelling.simpleLogistic.models.Delivery;
import com.thonwelling.simpleLogistic.services.DeliveryOrderRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery/v1")
public class DeliveryController {

  @Autowired
  DeliveryOrderRequestService deliveryService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Delivery requestDelivery(@RequestBody Delivery delivery){
    return deliveryService.requestDelivery(delivery);
  }
}