package com.comercio.lancamento.infra.rest.controller.impl;

import com.comercio.lancamento.infra.rest.controller.LancamentoController;
import com.comercio.lancamento.usecase.model.form.LancamentoForm;
import com.comercio.lancamento.usecase.service.LancamentoService;
import com.comercio.lancamento.usecase.model.view.LancamentoView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lancamentos")
@RequiredArgsConstructor
public class LancamentoControllerImpl implements LancamentoController {

    private final LancamentoService lancamentoService;

    @Override
    public ResponseEntity<LancamentoView> create(final LancamentoForm form) {
        return ResponseEntity.ok(lancamentoService.create(form));
    }
}
