package com.thonwelling.simpleLogistic.models.dto;

import com.thonwelling.simpleLogistic.models.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryDTO {
  private Long id;
  private String clientName;
  private RecipientDTO recipient;
  private BigDecimal tax;
  private DeliveryStatus deliveryStatus;
  private OffsetDateTime orderDate;
  private OffsetDateTime completionDate;
}
