package com.mongodb.workshop_mongodb.controllers.exceptions;

import com.mongodb.workshop_mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest httpServletRequest){

        StandardError standardError = new StandardError(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                new Date(),
                httpServletRequest.getRequestURI(),
                "Não encontrado!");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);

    }

}
