package com.picpaychallenge.picpaychallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * Class created to treat exceptions that happens when a search doesn't get
 * a result.
 *
 * @author Cayo Cutrim
 * @since 23/08/2023
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2764277934100093010L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}