package com.comercio.lancamento.usecase.service;

import com.comercio.lancamento.usecase.model.form.LancamentoForm;
import com.comercio.lancamento.usecase.model.view.LancamentoView;

public interface LancamentoService {
    LancamentoView create(LancamentoForm form);
}
