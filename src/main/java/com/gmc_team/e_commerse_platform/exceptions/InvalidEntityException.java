package com.gmc_team.e_commerse_platform.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

public class InvalidEntityException extends RuntimeException{
    @Getter
    private Errorcode errorCode;
    @Getter
    private HttpStatus status;
    @Getter
    private List<String> errors;

    public InvalidEntityException(String message, Errorcode errorCode,List<String> errors, HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
        this.errors = errors;
    }

    public InvalidEntityException(String message, Errorcode errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public InvalidEntityException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntityException(String message, Throwable cause, Errorcode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, Errorcode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public InvalidEntityException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }
}
