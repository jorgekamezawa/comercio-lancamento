package com.comercio.lancamento.infra.rest.exception.handler;

import com.comercio.lancamento.domain.exception.BadRequestException;
import com.comercio.lancamento.domain.exception.DatabaseException;
import com.comercio.lancamento.infra.rest.exception.view.ErrorView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDateTime.now;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorView> badRequestExceptionHandler(final BadRequestException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorView error = ErrorView.builder()
                .message(ex.getMessage())
                .status(status.value() + " " + status.name())
                .dateTime(localDateTimeToString(now()))
                .build();
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler({DatabaseException.class})
    public ResponseEntity<ErrorView> databaseExceptionHandler(final DatabaseException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorView error = ErrorView.builder()
                .message(ex.getMessage())
                .status(status.value() + " " + status.name())
                .dateTime(localDateTimeToString(now()))
                .build();
        ex.printStackTrace();
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<ErrorView> nullPointerExceptionHandler(final NullPointerException ex) {
        String parameterName = getParameterName(ex.getMessage());
        String message;
        HttpStatus status;
        if (parameterName != null) {
            status = HttpStatus.BAD_REQUEST;
            message = "O parametro " + parameterName + " é nulo!";
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            message = "Existem campos nulos onde nao deveria, favor entrar em contato com o administrador!";
        }

        ErrorView error = ErrorView.builder()
                .message(message)
                .status(status.value() + " " + status.name())
                .dateTime(localDateTimeToString(now()))
                .build();
        ex.printStackTrace();
        return ResponseEntity.status(status).body(error);
    }

    private String getParameterName(String message) {
        String searchPhrase = " is marked non-null but is null";
        int endIndex = message.indexOf(searchPhrase);

        if (endIndex != -1) {
            return message.substring(0, endIndex);
        } else return null;
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorView> genericExceptionHandler(final Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorView error = ErrorView.builder()
                .message("Erro nao identificado, favor entrar em contato com o administrador!")
                .status(status.value() + " " + status.name())
                .dateTime(localDateTimeToString(now()))
                .build();
        ex.printStackTrace();
        return ResponseEntity.status(status).body(error);
    }

    private String localDateTimeToString(final LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
