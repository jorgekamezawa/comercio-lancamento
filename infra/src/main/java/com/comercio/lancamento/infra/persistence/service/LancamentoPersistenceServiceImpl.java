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

@Service
@RequiredArgsConstructor
public class LancamentoPersistenceServiceImpl implements LancamentoPersistenceService {

    private final LancamentoRepository lancamentoRepository;
    private final LancamentoPersistenceMapper lancamentoMapper;

    @Override
    public Lancamento save(Lancamento domain) {
        LancamentoEntity entity = lancamentoRepository.save(lancamentoMapper.toEntity(domain));
        return lancamentoMapper.toDomain(entity);
    }

    @Override
    public Page<Lancamento> findAll(Pageable pageable) {
        return lancamentoRepository.findAll(pageable).map(lancamentoMapper::toDomain);
    }
}
