package GrowerFarmFieldAPI.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GrowerNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(GrowerNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String growerNotFoundHandler(GrowerNotFoundException ex) {
        return ex.getMessage();
    }
}
