package com.thonwelling.simpleLogistic.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientDTO {
  private String name;
  private String street;
  private Integer number;
  private String complement;
  private String neiborhood;
}
