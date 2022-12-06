package com.informatorio.app.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.informatorio.app.exception.AlreadyExistException;
import com.informatorio.app.exception.BadRequestException;
import com.informatorio.app.exception.InvalidPasswordException;


@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {
	
	
	
	DateFormat df = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");

	String formattedDate = df.format(new Date());

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new HashMap<>();


		body.put("status", status.value());
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);
		body.put("timestamp", formattedDate);

		return new ResponseEntity<>(body, headers, status);

	}
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException (NotFoundException ex, WebRequest request) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", formattedDate);
		body.put("status",HttpStatus.NOT_FOUND.value());
		body.put("errors", "Resource not found");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AlreadyExistException.class)
	public ResponseEntity<Object> handleUserAlreadyExistException(
		AlreadyExistException ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", formattedDate);
		body.put("status",HttpStatus.BAD_REQUEST.value());
		body.put("errors", ex.getMessage());

		    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
		  }
	
	
	
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<Object> handleUserAlreadyExistException(
		InvalidPasswordException ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", formattedDate);
		body.put("status",HttpStatus.UNAUTHORIZED.value());
		body.put("errors", ex.getMessage());

		    return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
		  }
	
	@ExceptionHandler(BadRequestException.class)	
	public ResponseEntity<Object> handleBadRequest(
			BadRequestException ex) {
			Map<String, Object> body = new HashMap<>();
			body.put("timestamp", formattedDate);
			body.put("status",HttpStatus.BAD_REQUEST.value());
			body.put("errors", ex.getMessage());

			    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
			  }
}
