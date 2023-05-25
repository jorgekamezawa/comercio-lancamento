package com.comercio.lancamento.usecase.model.form;

import com.comercio.lancamento.domain.entity.TipoPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
