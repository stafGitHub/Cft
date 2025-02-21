package org.cft_latest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CftLatestApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CftLatestApplication.class, args);
    }
}