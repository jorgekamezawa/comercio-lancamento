package com.comercio.lancamento.usecase.persistence;

import com.comercio.lancamento.domain.entity.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoPersistenceService {
    Lancamento save(Lancamento domain);

    Page<Lancamento> findAll(Pageable pageable);
}
