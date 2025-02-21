package org.cft_latest.service;

import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationArgs;
import org.cft_latest.dto.ApplicationFile;
import org.cft_latest.repository.fileRepo.FileOperationRepository;
import org.cft_latest.save.strategy.StringSaveFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {
    private final ApplicationArgs configArgs;
    private final FileOperationRepository fileOperationRepository;

    public ApplicationFile.ApplicationFileBuilder createBuilderApplicationFile() {

        List<File> files = new ArrayList<>();
        configArgs.getFilePath()
                .forEach(s -> files.add(new File(s)));


        ApplicationFile.ApplicationFileBuilder applicationFileBuilder = ApplicationFile.builder();

        ApplicationFile.ApplicationFileBuilder execute = fileOperationRepository.execute(files, applicationFileBuilder);
        return execute;
    }
}
