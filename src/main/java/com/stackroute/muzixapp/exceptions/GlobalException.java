package com.stackroute.muzixapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity trackNotFoundException(final TrackNotFoundException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public ResponseEntity trackAlreadyExistsException(final TrackAlreadyExistsException e){
        return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }




}
