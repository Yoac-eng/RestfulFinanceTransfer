package com.picpaychallenge.picpaychallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class created to treat exceptions that happens when trying to persist a null object.
 *
 * @author Cayo Cutrim
 * @since 23/08/2023
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException {

    private static final long serialVersionUID = 1960739288488803144L;

    public RequiredObjectIsNullException() {
        super("Não é permitido persistir um objeto nulo.");
    }

    public RequiredObjectIsNullException(String message) {
        super(message);
    }
}