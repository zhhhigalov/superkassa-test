package ru.zhigalov.superkassa.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.zhigalov.superkassa.exception.ObjectNotFoundException;

@ControllerAdvice
public class SuperExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectNotFoundException.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public void handleDefaultException(Exception e) {
        if (e instanceof ObjectNotFoundException) {
            LOGGER.debug(e.getMessage());
        }
    }
}
