package com.thonwelling.simpleLogistic.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Recipient {
  @NotBlank(message = "Precisa Ser Preenchido.")
  @Column(name = "recipient_name")
  private String name;

  @Column(name = "recipient_street")
  @NotBlank(message = "Precisa Ser Preenchido.")
  private String Street;

  @NotBlank(message = "Precisa Ser Preenchido.")
  @Column(name = "recipient_number")
  private Integer number;

  @NotBlank(message = "Precisa Ser Preenchido.")
  @Column(name = "recipient_complement")
  private String complement;

  @NotBlank(message = "Precisa Ser Preenchido.")
  @Column(name = "recipient_neighborhood")
  private String neighborhood;
}
