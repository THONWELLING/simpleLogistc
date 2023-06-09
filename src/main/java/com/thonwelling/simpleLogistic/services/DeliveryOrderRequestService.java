package com.thonwelling.simpleLogistic.services;


import com.thonwelling.simpleLogistic.exception.BusinesException;
import com.thonwelling.simpleLogistic.models.Client;
import com.thonwelling.simpleLogistic.models.Delivery;
import com.thonwelling.simpleLogistic.models.DeliveryStatus;
import com.thonwelling.simpleLogistic.repositories.ClientRepository;
import com.thonwelling.simpleLogistic.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
public class DeliveryOrderRequestService {
  @Autowired
  DeliveryRepository deliveryRepository;
  @Autowired
  ClientService clientService;

  @Transactional
  public Delivery requestDelivery(Delivery delivery) {
    Client client = clientService.get(delivery.getClient().getId());

    delivery.setClient(client);
    delivery.setDeliveryStatus(DeliveryStatus.PENDING);
    delivery.setOrderDate(OffsetDateTime.now());
    return deliveryRepository.save(delivery);
  }
}
