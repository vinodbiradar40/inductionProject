package com.orders.ordering.ExceptionHandle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;

@RestController
@ControllerAdvice
public class HandlingException 
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException(MethodArgumentNotValidException hp)
	{
		Map<String,String> errorMap=new HashMap<>();
		hp.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(),error.getDefaultMessage());
		});
		
		return errorMap;
	}

	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public String myException(MethodArgumentNotValidException s)
//	{
//		
//		return "Please provide a Valid Input";
//	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> idException(HttpMessageNotReadableException hp)
	{
		return new ResponseEntity<>("Not a valid Id.",HttpStatus.OK);
	}
	
}
