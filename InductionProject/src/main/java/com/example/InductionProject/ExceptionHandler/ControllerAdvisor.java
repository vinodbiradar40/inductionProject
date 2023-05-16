package com.example.InductionProject.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@ControllerAdvice
public class ControllerAdvisor {
	@ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handleException(MethodArgumentNotValidException hp) {
        Map<String, String> errorMap = new HashMap();
        hp.getBindingResult().getFieldErrors().forEach((error) -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<String> handleUserException(UserNotFoundException ue)
    {
        String errorMessage = "User Not Found";
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
