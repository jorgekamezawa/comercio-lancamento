package com.comercio.lancamento.infra.rest.controller;

import com.comercio.lancamento.usecase.model.form.LancamentoForm;
import com.comercio.lancamento.usecase.model.view.LancamentoConsolidadoView;
import com.comercio.lancamento.usecase.model.view.LancamentoView;
import com.comercio.lancamento.usecase.model.view.PageableView;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

public interface LancamentoController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    LancamentoView create(@Valid @RequestBody final LancamentoForm form);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    PageableView<LancamentoView> findAll(@PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) final Pageable pageable);

    @GetMapping("/consolidado")
    @ResponseStatus(HttpStatus.OK)
    LancamentoConsolidadoView consolidado(@RequestParam final LocalDate dataInicio, @RequestParam(required = false) final LocalDate dataFim);
}
