package com.gmc_team.e_commerse_platform.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends RuntimeException{

    @Getter
    private Errorcode errorCode;
    @Getter
    private HttpStatus status;

    public EntityNotFoundException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message, Throwable cause, Errorcode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public EntityNotFoundException(String message, Errorcode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public EntityNotFoundException(String message, Errorcode errorCode ,HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }
}
