package com.comercio.lancamento.usecase.model.form;

import com.comercio.lancamento.domain.entity.TipoPagamentoEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoForm {
    private UUID id;
    @Positive
    private BigDecimal valor;
    @NotNull
    private TipoPagamentoEnum tipoPagamento;
}
