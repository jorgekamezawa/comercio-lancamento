package com.comercio.lancamento.infra.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicsConfig {

    @Value("${kafka.topic.create-relatorio-consolidado}")
    private String topicCreateRelatorioConsolidado;

    @Value("${kafka.topic.send-relatorio-consolidado}")
    private String topicSendRelatorioConsolidado;

    @Bean
    public KafkaAdmin.NewTopics createTopics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(topicCreateRelatorioConsolidado)
                        .partitions(3)
                        .build(),
                TopicBuilder.name(topicSendRelatorioConsolidado)
                        .partitions(3)
                        .build());
    }
}
