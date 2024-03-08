package com.bus_reservation_project.exception;

import com.bus_reservation_project.payload.ErrorDetailes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetailes>handleResourceNotFoundException(
            ResourceNotFoundException e,
            WebRequest webRequest
    ){
        ErrorDetailes errorDetailes=new ErrorDetailes(
                e.getMessage(),new Date(), webRequest.getDescription(true)
        );
        return new ResponseEntity<>(errorDetailes, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(
            Exception e,
            WebRequest webRequest
    ){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
