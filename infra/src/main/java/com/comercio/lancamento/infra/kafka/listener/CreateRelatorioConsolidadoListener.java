package com.comercio.lancamento.infra.kafka.listener;

import com.comercio.lancamento.domain.exception.KafkaException;
import com.comercio.lancamento.infra.kafka.producer.SendRelatorioConsolidadoProducer;
import com.comercio.lancamento.infra.kafka.message.CreateRelatorioConsolidadoMessage;
import com.comercio.lancamento.usecase.model.view.LancamentoConsolidadoView;
import com.comercio.lancamento.usecase.service.RelatorioLancamentoConsolidadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateRelatorioConsolidadoListener {

    private final ObjectMapper mapper;
    private final RelatorioLancamentoConsolidadoService relatorioLancamentoConsolidadoService;
    private final SendRelatorioConsolidadoProducer sendRelatorioConsolidadoProducer;

    @KafkaListener(topics = "${kafka.topic.create-relatorio-consolidado}", groupId = "lancamento-group")
    public void listen(String message) {
        System.out.println("MENSAGEM RECEBIDA -> " + message);
        CreateRelatorioConsolidadoMessage response;
        try {
            response = mapper.readValue(message, CreateRelatorioConsolidadoMessage.class);
        } catch (Exception ex) {
            throw new KafkaException("Deu erro na conversao da mensagem do Kafka", ex);
        }

        LancamentoConsolidadoView relatorio = relatorioLancamentoConsolidadoService.relatorioConsolidadoByCreatedAt(
                response.getDataInico(), response.getDataFim());

        sendRelatorioConsolidadoProducer.sendRelatorio(relatorio);
    }
}
