package com.platzi.play.web.exception;

import com.platzi.play.domain.exception.MovieAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handlerException(MovieAlreadyExistsException e){
        Error error = new Error("MovieAlreadyExistsException", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handlerException(MethodArgumentNotValidException e){
        List<Error> errors = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            errors.add(new Error(field, message));
        });

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handlerException(Exception ex){
        Error error = new Error("unknown-error", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
