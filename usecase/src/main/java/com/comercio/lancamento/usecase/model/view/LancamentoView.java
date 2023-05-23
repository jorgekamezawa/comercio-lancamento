package com.comercio.lancamento.usecase.model.view;

import com.comercio.lancamento.domain.entity.TipoPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoView {
    private UUID id;
    private BigDecimal valor;
    private TipoPagamentoEnum tipoPagamento;
    private LocalDateTime createdAt;
}
