package com.thonwelling.simpleLogistic.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thonwelling.simpleLogistic.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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

  @NotNull(message = "O Cliente Não Pode Ser Nulo!!")
  @ManyToOne
  @Valid
  @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
  private Client client;

  @Embedded
  @NotNull(message = "O Cliente Não Pode ser Nulo!!")
  @Valid
  private Recipient recipient;

  @NotNull(message = "A Taxa Não Pode Ser Nula!!")
  private BigDecimal tax;

  @Enumerated(EnumType.STRING)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private DeliveryStatus deliveryStatus;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private OffsetDateTime orderDate;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private OffsetDateTime completionDate;
}