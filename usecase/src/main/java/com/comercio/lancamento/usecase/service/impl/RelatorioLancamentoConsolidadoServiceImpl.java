package com.comercio.lancamento.usecase.service.impl;

import com.comercio.lancamento.domain.entity.Lancamento;
import com.comercio.lancamento.domain.entity.TipoPagamentoEnum;
import com.comercio.lancamento.usecase.mapper.LancamentoMapper;
import com.comercio.lancamento.usecase.model.exception.BadRequestException;
import com.comercio.lancamento.usecase.model.view.LancamentoConsolidadoView;
import com.comercio.lancamento.usecase.persistence.LancamentoPersistenceService;
import com.comercio.lancamento.usecase.service.RelatorioLancamentoConsolidadoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RelatorioLancamentoConsolidadoServiceImpl implements RelatorioLancamentoConsolidadoService {

    private final LancamentoPersistenceService lancamentoPersistenceService;
    private final LancamentoMapper lancamentoMapper;

    @Override
    public LancamentoConsolidadoView relatorioConsolidadoByCreatedAt(@NonNull final LocalDate dataInicio, final LocalDate dataFim) {
        LocalDateTime dataHoraInicio = dataInicio.atStartOfDay();
        LocalDateTime dataHoraFim = getDataHoraFim(dataInicio, dataFim);

        List<Lancamento> lancamentoList = lancamentoPersistenceService.findAll(dataHoraInicio, dataHoraFim);
        BigDecimal saldoConsolidado = getSaldoConsolidado(lancamentoList);

        return new LancamentoConsolidadoView(lancamentoList.stream().map(lancamentoMapper::toView).toList(), saldoConsolidado);
    }

    private LocalDateTime getDataHoraFim(@NonNull final LocalDate dataInicio, final LocalDate dataFim) {
        if (dataFim == null) return dataInicio.atTime(LocalTime.MAX);

        if (dataInicio.isAfter(dataFim)) {
            throw new BadRequestException("A data inicio nao pode ser posterior a data fim!");
        }
        return dataFim.atTime(LocalTime.MAX);
    }

    private BigDecimal getSaldoConsolidado(List<Lancamento> lancamentoList) {
        BigDecimal creditoConsolidado = BigDecimal.ZERO;
        BigDecimal debitoConsolidado = BigDecimal.ZERO;

        for (Lancamento lancamento : lancamentoList) {
            if (lancamento.getTipoPagamento().equals(TipoPagamentoEnum.CREDITO)) {
                creditoConsolidado = creditoConsolidado.add(lancamento.getValor());
            }

            if (lancamento.getTipoPagamento().equals(TipoPagamentoEnum.DEBITO)) {
                debitoConsolidado = debitoConsolidado.add(lancamento.getValor());
            }
        }

        return creditoConsolidado.subtract(debitoConsolidado);
    }
}
