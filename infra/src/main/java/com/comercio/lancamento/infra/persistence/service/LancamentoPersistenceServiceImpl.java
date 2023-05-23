package com.comercio.lancamento.infra.persistence.service;

import com.comercio.lancamento.domain.entity.Lancamento;
import com.comercio.lancamento.infra.persistence.entity.LancamentoEntity;
import com.comercio.lancamento.infra.persistence.mapper.LancamentoPersistenceMapper;
import com.comercio.lancamento.infra.persistence.repository.LancamentoRepository;
import com.comercio.lancamento.usecase.persistence.LancamentoPersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LancamentoPersistenceServiceImpl implements LancamentoPersistenceService {

    private final LancamentoRepository lancamentoRepository;
    private final LancamentoPersistenceMapper lancamentoMapper;

    @Override
    public Lancamento save(final Lancamento domain) {
        LancamentoEntity entity = lancamentoRepository.save(lancamentoMapper.toEntity(domain));
        return lancamentoMapper.toDomain(entity);
    }

    @Override
    public Page<Lancamento> findAll(final Pageable pageable) {
        return lancamentoRepository.findAll(pageable).map(lancamentoMapper::toDomain);
    }

    @Override
    public List<Lancamento> findAll(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        return lancamentoRepository.findByCreatedAtBetween(dataHoraInicio, dataHoraFim).stream()
                .map(lancamentoMapper::toDomain)
                .toList();
    }
}
