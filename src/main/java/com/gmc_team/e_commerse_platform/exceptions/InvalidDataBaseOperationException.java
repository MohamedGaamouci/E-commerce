package com.gmc_team.e_commerse_platform.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;


public class InvalidDataBaseOperationException extends RuntimeException {
    @Getter
    private HttpStatus status;

    @Getter
    private Errorcode errorCode;

    public InvalidDataBaseOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDataBaseOperationException(String message, HttpStatus status, Errorcode errorCode) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }

    public InvalidDataBaseOperationException(String message, Errorcode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
