package org.cft_latest.repository.fileRepo.operation;

import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationFile;
import org.cft_latest.repository.fileRepo.FileOperation;
import org.cft_latest.repository.fileRepo.UtilFileReader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * ReadFloatFile - читает фалы , переданные в командную строку , выделяя из них строки типа Float
 */
@Component
@RequiredArgsConstructor
public class ReadFloatFile implements FileOperation<List<File>, ApplicationFile.ApplicationFileBuilder> {
    private final UtilFileReader utilFileReader;

    @Override
    public void operate(List<File> input, ApplicationFile.ApplicationFileBuilder applicationFile) {
        List<String> allLines = new ArrayList<>();

        utilFileReader.readFile(allLines,input);

        List<String> floatLines = allLines.stream()
                .filter(utilFileReader::isFloat)
                .toList();

        applicationFile.floats(floatLines);
    }
}