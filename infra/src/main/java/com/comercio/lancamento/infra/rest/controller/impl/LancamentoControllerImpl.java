package com.comercio.lancamento.infra.rest.controller.impl;

import com.comercio.lancamento.infra.rest.controller.LancamentoController;
import com.comercio.lancamento.usecase.model.form.LancamentoForm;
import com.comercio.lancamento.usecase.model.view.LancamentoConsolidadoView;
import com.comercio.lancamento.usecase.model.view.LancamentoView;
import com.comercio.lancamento.usecase.model.view.PageableView;
import com.comercio.lancamento.usecase.service.LancamentoService;
import com.comercio.lancamento.usecase.service.RelatorioLancamentoConsolidadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/lancamentos")
@RequiredArgsConstructor
public class LancamentoControllerImpl implements LancamentoController {

    private final LancamentoService lancamentoService;
    private final RelatorioLancamentoConsolidadoService relatorioLancamentoConsolidadoService;

    @Override
    public LancamentoView create(final LancamentoForm form) {
        return lancamentoService.create(form);
    }

    @Override
    public PageableView<LancamentoView> findAll(final Pageable pageable) {
        return lancamentoService.findAll(pageable);
    }

    @Override
    public LancamentoConsolidadoView consolidado(final LocalDate dataInicio, final LocalDate dataFim) {
        return relatorioLancamentoConsolidadoService.relatorioConsolidadoByCreatedAt(dataInicio, dataFim);
    }
}
