package com.example.DemoProject.ExceptionHandler;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControllerAdvisor {
	
	@ExceptionHandler({NoSuchElementException.class})
	public String handleUserNotFoundException(NoSuchElementException ex)
	{
		return ex.getMessage();
	}



//	@ExceptionHandler({MethodArgumentNotValidException.class})
//    public Map<String, String> handleException(MethodArgumentNotValidException hp) {
//        Map<String, String> errorMap = new HashMap();
//        hp.getBindingResult().getFieldErrors().forEach((error) -> {
//            errorMap.put(error.getField(), error.getDefaultMessage());
//        });
//        return errorMap;
//    }
}
