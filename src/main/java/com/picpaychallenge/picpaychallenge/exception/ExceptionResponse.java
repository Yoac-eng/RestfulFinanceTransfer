package com.picpaychallenge.picpaychallenge.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Class that maps a response to an exception.
 *
 * @author Cayo Cutrim, 17/08/2023
 *
 */
@Getter
@Setter
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 2830105291406454433L;

    private Date timestamp;
    private String messages;
    private String details;

    public ExceptionResponse(Date timestamp, String messages, String details) {
        super();
        this.timestamp = timestamp;
        this.messages = messages;
        this.details = details;
    }
}