package com.picpaychallenge.picpaychallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class created to treat exceptions that happens when an invalid field
 * is trying to be persisted.
 *
 * @author Cayo Cutrim
 * @since 23/08/2023
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFieldException extends RuntimeException {

    private static final long serialVersionUID = 8747835219347564060L;

    public InvalidFieldException(String message) {
        super(message);
    }
}