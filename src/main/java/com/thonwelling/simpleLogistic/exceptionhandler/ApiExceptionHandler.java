package com.thonwelling.simpleLogistic.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  @Autowired
  MessageSource messageSource;

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                HttpHeaders headers, HttpStatusCode status, WebRequest request) {

    List<TroubleBody.ObjectField> fields = new ArrayList<>();

    for(ObjectError error : exception.getBindingResult().getAllErrors()) {
      String name = ((FieldError) error).getField();
      String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

      fields.add(new TroubleBody.ObjectField(name, message));
    }

    TroubleBody trouble = new TroubleBody();
    trouble.setStatus(status.value());
    trouble.setDataHora(LocalDateTime.now());
    trouble.setTitle("Um ou Mais Campós Estão Inválidos. Preencha corretamente");
    trouble.setFields(fields);

    return handleExceptionInternal(exception, trouble, headers, status, request);
  }
}
