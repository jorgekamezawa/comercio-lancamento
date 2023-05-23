package com.comercio.lancamento.usecase.mapper;

import com.comercio.lancamento.domain.entity.Lancamento;
import com.comercio.lancamento.usecase.model.form.LancamentoForm;
import com.comercio.lancamento.usecase.model.view.LancamentoView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        nullValueCheckStrategy = ALWAYS
)
public interface LancamentoMapper {

    @Mapping(target = "id", ignore = true)
    Lancamento toDomain(final LancamentoForm form);

    LancamentoView toView(final Lancamento domain);
}
