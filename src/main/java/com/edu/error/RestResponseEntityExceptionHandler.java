package com.edu.error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.edu.dao.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
@ExceptionHandler(EmployeeNotFoundException.class)
public ResponseEntity<ErrorMessage> EmployeeNotFoundException(EmployeeNotFoundException exception,WebRequest request) {
	ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
   }

@ExceptionHandler(DepartmentNotFoundException.class)
public ResponseEntity<ErrorMessage> DepartmentNotFoundException(DepartmentNotFoundException exception,WebRequest request) {
	ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
}
}

// import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import com.event.entity.ErrorMessage;
//
//@ControllerAdvice
//@ResponseStatus
//public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
//@ExceptionHandler(GlobalException.class)
//
//public ResponseEntity<ErrorMessage> globalException(GlobalException exception,WebRequest request) {
//	ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
//	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
//  }
//}
//* import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import com.event.entity.ErrorMessage;
//
//@ControllerAdvice
//@ResponseStatus
//public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
//@ExceptionHandler(GlobalException.class)
//
//public ResponseEntity<ErrorMessage> globalException(GlobalException exception,WebRequest request) {
//	ErrorMessage message=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
//	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
//  }
//}



