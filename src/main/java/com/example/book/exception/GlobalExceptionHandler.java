package com.example.book.exception;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BookUnSupportFieldPatchException.class)
		public void springUnSupportFieldPatch(HttpServletResponse response) throws IOException
		{
		response.sendError(HttpStatus.METHOD_NOT_ALLOWED.value());	
		}
	}


