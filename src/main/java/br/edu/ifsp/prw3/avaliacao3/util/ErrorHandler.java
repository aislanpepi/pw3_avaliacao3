package br.edu.ifsp.prw3.avaliacao3.util;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleError400(MethodArgumentNotValidException ex){
        var errors = ex.getFieldErrors();
        var list = errors.stream().map(ValidationErrorsData::new).toList();

        return ResponseEntity.badRequest().body(list);
    }

    private record ValidationErrorsData(String field, String errMsg){
        public ValidationErrorsData(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
