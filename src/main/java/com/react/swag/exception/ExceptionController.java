package com.react.swag.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.react.swag.exception.classes.BuildingDetailsNotAdded;
import com.react.swag.exception.classes.BuildingNotFound;

@RestControllerAdvice
public class ExceptionController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> validationsCheckErrors(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(err -> {
			errorMap.put(err.getField(), err.getDefaultMessage());
		});
		return errorMap;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public Map<String, String> argumentsMissmatch(MethodArgumentTypeMismatchException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put(ex.getName(), ex.getMessage());
		return errorMap;

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Map<String,String> argumentsMissmatch(HttpMessageNotReadableException ex)
	{
		Map<String,String>errorMap=new HashMap<>();
		errorMap.put("ErrorMessege : ", ex.getMessage().toString());
        return errorMap;
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(BuildingDetailsNotAdded.class)
	public Map<String, String> buildingNotAdded(BuildingDetailsNotAdded ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("Error Messege : ", ex.getMessage());

		return errorMap;

	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(BuildingNotFound.class)
	public Map<String, String> buildingNotFound(BuildingNotFound ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("Error Messege : ", ex.getMessage());
		return errorMap;

	}
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NullPointerException.class)
	public Map<String, String> buildingNotFound(NullPointerException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("Error Messege : ", ex.getMessage());
		return errorMap;
	}
}