package com.comercio.lancamento.usecase.service;

import com.comercio.lancamento.usecase.model.form.LancamentoForm;
import com.comercio.lancamento.usecase.model.view.LancamentoView;
import com.comercio.lancamento.usecase.model.view.PageableView;
import org.springframework.data.domain.Pageable;

public interface LancamentoService {
    LancamentoView create(LancamentoForm form);

    PageableView<LancamentoView> findAll(Pageable pageable);
}
