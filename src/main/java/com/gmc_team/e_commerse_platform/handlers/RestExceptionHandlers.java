package com.gmc_team.e_commerse_platform.handlers;

import com.gmc_team.e_commerse_platform.exceptions.EntityNotFoundException;
import com.gmc_team.e_commerse_platform.exceptions.InvalidDataBaseOperationException;
import com.gmc_team.e_commerse_platform.exceptions.InvalidEntityException;
import com.gmc_team.e_commerse_platform.exceptions.InvalidOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandlers extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webRequest) {

        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCode())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorDto, notFound);
    }

    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidOperationException exception, WebRequest webRequest) {

        final HttpStatus notFound = HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCode())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();

        if(exception.getStatus()==null){
            errorDto.setHttpCode(notFound.value());
            return new ResponseEntity<>(errorDto, notFound);
        }else{
            errorDto.setHttpCode(exception.getStatus().value());
            return new ResponseEntity<>(errorDto, exception.getStatus());
        }
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest) {
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCode())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();


        if(exception.getStatus()==null){
            errorDto.setHttpCode(badRequest.value());
            return new ResponseEntity<>(errorDto, badRequest);
        }else{
            errorDto.setHttpCode(exception.getStatus().value());
            return new ResponseEntity<>(errorDto, exception.getStatus());
        }
    }
    @ExceptionHandler(InvalidDataBaseOperationException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidDataBaseOperationException exception, WebRequest webRequest) {
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        final ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getErrorCode())
                .message(exception.getMessage())
                .build();


        if(exception.getStatus()==null){
            errorDto.setHttpCode(badRequest.value());
            return new ResponseEntity<>(errorDto, badRequest);
        }else{
            errorDto.setHttpCode(exception.getStatus().value());
            return new ResponseEntity<>(errorDto, exception.getStatus());
        }
    }

//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<ErrorDto> handleException(BadCredentialsException exception, WebRequest webRequest) {
//        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
//
//        final ErrorDto errorDto = ErrorDto.builder()
//                .code(Errorcode.BAD_CREDENTIALS)
//                .httpCode(badRequest.value())
//                .message(exception.getMessage())
//                .errors(Collections.singletonList("Login et / ou mot de passe incorrecte"))
//                .build();
//
//        return new ResponseEntity<>(errorDto, badRequest);
//    }
}
