package com.comercio.lancamento.usecase.service;

import com.comercio.lancamento.usecase.model.view.LancamentoConsolidadoView;

import java.time.LocalDate;

public interface RelatorioLancamentoConsolidadoService {
    LancamentoConsolidadoView relatorioConsolidadoByCreatedAt(final LocalDate dataInicio, final LocalDate dataFim);
}
