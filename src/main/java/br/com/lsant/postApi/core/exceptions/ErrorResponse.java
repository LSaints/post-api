package br.com.lsant.postApi.core.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
public class ErrorResponse implements Serializable {
    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ErrorResponse() {}

}
