package com.thonwelling.simpleLogistic.exceptionhandler;

import com.thonwelling.simpleLogistic.exception.BusinesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  @Autowired
  MessageSource messageSource;

  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                HttpHeaders headers, HttpStatusCode status, WebRequest request) {

    List<ObjectField> fields = new ArrayList<>();

    for(ObjectError error : exception.getBindingResult().getAllErrors()) {
      String name = ((FieldError) error).getField();
      String message = error.getDefaultMessage();

      fields.add(new ObjectField(name, message));
    }

    TroubleBody trouble = new TroubleBody(status.value(), OffsetDateTime.now(),
        "One or More Fields Are Not Valid. Please Fill it Correctly", fields);

    return handleExceptionInternal(exception, trouble, headers, status, request);
  }

  @ExceptionHandler(BusinesException.class)
  public ResponseEntity<Object> handleBusinessException(BusinesException ex, WebRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    TroubleBody trouble = new TroubleBody();
    trouble.setStatus(status.value());
    trouble.setDataHora(OffsetDateTime.now());
    trouble.setTitle(ex.getMessage());

    return handleExceptionInternal(ex, trouble, new HttpHeaders(), status, request);
  }
}
