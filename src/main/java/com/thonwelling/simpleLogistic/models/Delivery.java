package com.thonwelling.simpleLogistic.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Delivery {
  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Client client;

  @Embedded
  private Recipient recipient;
  private BigDecimal tax;

  @Enumerated(EnumType.STRING)
  private DeliveryStatus deliveryStatus;
  private OffsetDateTime orderDate;
  private OffsetDateTime completionDate;
}
