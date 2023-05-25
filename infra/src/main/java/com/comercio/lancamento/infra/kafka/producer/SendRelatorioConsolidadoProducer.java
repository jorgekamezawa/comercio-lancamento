package com.comercio.lancamento.infra.kafka.producer;

import com.comercio.lancamento.domain.exception.KafkaException;
import com.comercio.lancamento.usecase.model.view.LancamentoConsolidadoView;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendRelatorioConsolidadoProducer {

    @Value("${kafka.topic.send-relatorio-consolidado}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendRelatorio(LancamentoConsolidadoView view) {
        String message;
        try {
            message = objectMapper.writeValueAsString(view);
            System.out.println("ENVIANDO MENSAGEM -> " + message);
        } catch (Exception exception) {
            throw new KafkaException("Deu erro no mapper", exception);
        }
        kafkaTemplate.send(topic, message);
    }
}
