package org.cft_latest.applicationData.applicationArguments;

import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationArgs;
import org.cft_latest.service.ArgumentService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 *<d> ApplicationArgsConfig - компонент отвечающий за создание ApplicationArgs
 */
@Configuration
@RequiredArgsConstructor
public class ApplicationArgsConfig {
    private final ArgumentParser argumentParser;
    private final ArgumentService argumentService;

    @Bean(name = "configArgs")
    public ApplicationArgs argumentConfigure(ApplicationArguments input) {
            Map<String, Object> applicationArguments = argumentParser.argumentConfigure(input);
        return argumentService.createApplicationArgs(applicationArguments).build();

    }
}
