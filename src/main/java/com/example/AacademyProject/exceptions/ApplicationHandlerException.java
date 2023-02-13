package com.example.AacademyProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //този клас ще слуша цялото приложение за ексепшъните, кито сме подали тук, затова не наследява Exception
public class ApplicationHandlerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserNotFoundException.class)

    String handleUserNotFoundException(UserNotFoundException ex){
        return String.format(ex.getMessage());
    }
}
