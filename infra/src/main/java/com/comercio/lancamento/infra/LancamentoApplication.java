package com.comercio.lancamento.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.comercio.lancamento.*")
@SpringBootApplication
public class LancamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LancamentoApplication.class, args);
    }

}
