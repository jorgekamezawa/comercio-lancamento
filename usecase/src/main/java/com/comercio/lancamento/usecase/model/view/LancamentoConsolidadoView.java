package com.comercio.lancamento.usecase.model.view;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class LancamentoConsolidadoView {
    private List<LancamentoView> lancamentoList;
    private BigDecimal saldoConsolidado;
}
