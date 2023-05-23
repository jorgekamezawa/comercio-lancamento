package com.comercio.lancamento.infra.persistence.entity;

import com.comercio.lancamento.domain.entity.TipoPagamentoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

import static org.hibernate.annotations.UuidGenerator.Style.RANDOM;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lancamentos", schema = "comercio")
public class LancamentoEntity {
    @Id
    @GeneratedValue
    @UuidGenerator(style = RANDOM)
    private UUID id;
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pagamento", nullable = false)
    private TipoPagamentoEnum tipoPagamento;
}
