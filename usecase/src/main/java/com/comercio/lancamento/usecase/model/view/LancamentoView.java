package com.comercio.lancamento.usecase.model.view;

import com.comercio.lancamento.domain.entity.TipoPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoView {
    private BigDecimal valor;
    private TipoPagamentoEnum tipoPagamento;
}
