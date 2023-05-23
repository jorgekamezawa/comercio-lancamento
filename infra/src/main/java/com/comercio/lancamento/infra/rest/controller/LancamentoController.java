package com.comercio.lancamento.infra.rest.controller;

import com.comercio.lancamento.usecase.model.form.LancamentoForm;
import com.comercio.lancamento.usecase.model.view.LancamentoView;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface LancamentoController {

    @PostMapping
    ResponseEntity<LancamentoView> create(@Valid @RequestBody final LancamentoForm form);
}
