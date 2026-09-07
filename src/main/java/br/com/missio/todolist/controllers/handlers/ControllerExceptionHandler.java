package br.com.missio.todolist.controllers.handlers;

import br.com.missio.todolist.dto.CustomError;
import br.com.missio.todolist.services.exceptions.ResorceNotFoundExceprion;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResorceNotFoundExceprion.class)
    public ResponseEntity<CustomError> custonName(ResorceNotFoundExceprion ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
