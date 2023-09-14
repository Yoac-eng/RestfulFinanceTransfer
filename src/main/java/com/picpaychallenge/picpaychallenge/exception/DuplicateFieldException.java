package com.picpaychallenge.picpaychallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class created to treat exceptions that happens when a duplicate field
 * is trying to be persisted while a constraint restricts it.
 *
 * @author Cayo Cutrim
 * @since 13/09/2023
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateFieldException extends RuntimeException {

    private static final long serialVersionUID = -3895940955368525768L;

    public DuplicateFieldException(String message) {
        super(message);
    }
}