package com.thonwelling.simpleLogistic.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TroubleBody {
  private Integer status;
  private LocalDateTime dataHora;
  private String title;
  private List<ObjectField> fields;

  @AllArgsConstructor
  @Getter
  public static class ObjectField {
    private String name;
    private String message;
  }
}
