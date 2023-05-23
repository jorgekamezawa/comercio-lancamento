package com.comercio.lancamento.usecase.service.impl;

import com.comercio.lancamento.domain.entity.Lancamento;
import com.comercio.lancamento.usecase.mapper.LancamentoMapper;
import com.comercio.lancamento.usecase.model.form.LancamentoForm;
import com.comercio.lancamento.usecase.model.view.LancamentoView;
import com.comercio.lancamento.usecase.persistence.LancamentoPersistenceService;
import com.comercio.lancamento.usecase.service.LancamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LancamentoServiceImpl implements LancamentoService {

    private final LancamentoPersistenceService lancamentoPersistenceService;
    private final LancamentoMapper lancamentoMapper;

    @Override
    public LancamentoView create(LancamentoForm form) {
        Lancamento lancamento = lancamentoPersistenceService.save(lancamentoMapper.toDomain(form));
        return lancamentoMapper.toView(lancamento);
    }
}
