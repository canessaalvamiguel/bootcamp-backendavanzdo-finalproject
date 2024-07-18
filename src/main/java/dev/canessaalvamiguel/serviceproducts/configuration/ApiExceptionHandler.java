package dev.canessaalvamiguel.serviceproducts.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import dev.canessaalvamiguel.serviceproducts.exceptions.*;

@RestControllerAdvice
public class ApiExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  public ExceptionResponse notFoundRequest(Exception exception) {
    return new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value());
  }


}
