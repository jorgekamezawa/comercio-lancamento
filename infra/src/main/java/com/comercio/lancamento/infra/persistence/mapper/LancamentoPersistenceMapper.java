package com.comercio.lancamento.infra.persistence.mapper;

import com.comercio.lancamento.domain.entity.Lancamento;
import com.comercio.lancamento.infra.persistence.entity.LancamentoEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        nullValueCheckStrategy = ALWAYS
)
public interface LancamentoPersistenceMapper {

    LancamentoEntity toEntity(final Lancamento domain);

    Lancamento toDomain(final LancamentoEntity entity);
}
