package org.cft_latest.repository.fileRepo;

import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationFile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FileOperationRepository {
    private final List<FileOperation> fileOperation;

    public ApplicationFile.ApplicationFileBuilder execute(List<File> file,
                                                          ApplicationFile.ApplicationFileBuilder applicationFileBuilder) {

        fileOperation
                .forEach(fileOperation -> fileOperation.operate(file , applicationFileBuilder));
        return applicationFileBuilder;

    }
}
