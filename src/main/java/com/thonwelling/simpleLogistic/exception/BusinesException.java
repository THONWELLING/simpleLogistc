package com.thonwelling.simpleLogistic.exception;

import java.io.Serial;

public class BusinesException extends RuntimeException{
  @Serial
  private static final long serialVersionUID = 1L;

  public BusinesException(String message) {
    super(message);
  }
}
