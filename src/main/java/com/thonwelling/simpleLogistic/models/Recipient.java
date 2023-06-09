package com.thonwelling.simpleLogistic.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Recipient {
  @Column(name = "recipient_name")
  private String name;
  @Column(name = "recipient_street")
  private String Street;
  @Column(name = "recipient_number")
  private Integer number;
  @Column(name = "recipient_complement")
  private String complement;
  @Column(name = "recipient_neighborhood")
  private String neighborhood;
}
