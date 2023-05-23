package com.comercio.lancamento.infra.rest.controller;

import com.comercio.lancamento.usecase.model.form.LancamentoForm;
import com.comercio.lancamento.usecase.model.view.LancamentoView;
import com.comercio.lancamento.usecase.model.view.PageableView;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface LancamentoController {

    @PostMapping
    ResponseEntity<LancamentoView> create(@Valid @RequestBody final LancamentoForm form);

    @GetMapping
    ResponseEntity<PageableView<LancamentoView>> findAll(@PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable);
}
