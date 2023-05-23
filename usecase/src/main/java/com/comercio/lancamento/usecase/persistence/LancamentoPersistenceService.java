package com.comercio.lancamento.usecase.persistence;

import com.comercio.lancamento.domain.entity.Lancamento;

public interface LancamentoPersistenceService {
    Lancamento save(Lancamento domain);
}
