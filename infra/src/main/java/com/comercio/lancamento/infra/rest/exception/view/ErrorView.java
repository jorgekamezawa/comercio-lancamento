package com.comercio.lancamento.infra.rest.exception.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorView {
    private String status;
    private String message;
    private List<String> messageList;
    private String dateTime;
}
