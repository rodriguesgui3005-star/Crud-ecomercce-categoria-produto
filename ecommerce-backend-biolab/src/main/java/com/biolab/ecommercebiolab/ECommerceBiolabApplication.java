package com.biolab.ecommercebiolab;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class ECommerceBiolabApplication {
    @PostConstruct
    public void init() {
        // Define o fuso horário padrão da aplicação para Brasília
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
    public static void main(String[] args) {
        SpringApplication.run(ECommerceBiolabApplication.class, args);
    }

}
