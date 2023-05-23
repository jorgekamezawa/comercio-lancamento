package com.comercio.lancamento.infra.persistence.repository;

import com.comercio.lancamento.infra.persistence.entity.LancamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoEntity, UUID> {
    List<LancamentoEntity> findByCreatedAtBetween(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim);
}
