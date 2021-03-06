package com.evolent.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.evolent.constants.ResponseEnum;

@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
public class GenericExcpetionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

		List<Message> messages = new ArrayList<>();
		Message message = new Message(ResponseEnum.ERROR.toString(), "Internal Server Error", ex.getLocalizedMessage());
		messages.add(message);
		Response error = new Response(ResponseEnum.FAILURE.toString(), messages, null);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(RecordNotFoundException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());

		List<Message> messages = new ArrayList<>();

		Message message = new Message(ResponseEnum.ERROR.toString(), "Record Not Found", ex.getLocalizedMessage());
		messages.add(message);
		Response error = new Response(ResponseEnum.FAILURE.toString(), messages, null);
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}

}