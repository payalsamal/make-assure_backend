package com.make.assure.exceptions;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(BusinessException.class)
	public final ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex, WebRequest request)
			 {
		ErrorResponse response = new ErrorResponse(ex.getErrorCode(),ex.getErrorMsg(), ex.getFuncCode(), ex.getFuncDesc(),
			String.valueOf(MDC.get("errorId")));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	



}
