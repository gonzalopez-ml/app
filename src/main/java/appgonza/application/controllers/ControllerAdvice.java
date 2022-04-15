package appgonza.application.controllers;

import appgonza.application.dtos.ErrorDto;
import appgonza.application.exceptions.UsersNotFoundInDbException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = UsersNotFoundInDbException.class)
    public ResponseEntity<ErrorDto> UsersNotFoundInDbException(UsersNotFoundInDbException e) {
        ErrorDto errorDto = ErrorDto.builder().code(e.getCode()).message(e.getMessage()).build();
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
