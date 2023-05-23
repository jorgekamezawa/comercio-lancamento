package com.comercio.lancamento.usecase.persistence;

import com.comercio.lancamento.domain.entity.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface LancamentoPersistenceService {
    Lancamento save(Lancamento domain);

    Page<Lancamento> findAll(Pageable pageable);

    List<Lancamento> findAll(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim);
}
