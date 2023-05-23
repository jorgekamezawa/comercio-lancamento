package com.comercio.lancamento.infra.persistence.repository;

import com.comercio.lancamento.infra.persistence.entity.LancamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoEntity, UUID> {
}
