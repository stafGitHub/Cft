package org.cft_latest.applicationData.file;

import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationFile;
import org.cft_latest.service.FileService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * FileConfig - компонент , отвечающий за создание ApplicationFile
 */
@Component
@RequiredArgsConstructor
public class FileConfig {
    private final FileService fileService;

    @Bean(name = "fileConfigure")
    private ApplicationFile applicationFile() {
        ApplicationFile.ApplicationFileBuilder builderApplicationFile = fileService.createBuilderApplicationFile();
        return builderApplicationFile.build();
    }
}