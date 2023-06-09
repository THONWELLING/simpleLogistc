package com.thonwelling.simpleLogistic.repositories;

import com.thonwelling.simpleLogistic.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {}
