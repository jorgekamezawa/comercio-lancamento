package com.comercio.lancamento.domain.exception;

public class KafkaException extends RuntimeException {
    public KafkaException(String message) {
        super(message);
    }

    public KafkaException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
