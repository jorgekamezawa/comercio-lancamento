package com.comercio.lancamento.infra.rest.controller.impl;

import com.comercio.lancamento.infra.rest.controller.LancamentoController;
import com.comercio.lancamento.usecase.model.form.LancamentoForm;
import com.comercio.lancamento.usecase.model.view.LancamentoView;
import com.comercio.lancamento.usecase.model.view.PageableView;
import com.comercio.lancamento.usecase.service.LancamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoService.create(form));
    }

    @Override
    public ResponseEntity<PageableView<LancamentoView>> findAll(final Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.findAll(pageable));
    }
}
