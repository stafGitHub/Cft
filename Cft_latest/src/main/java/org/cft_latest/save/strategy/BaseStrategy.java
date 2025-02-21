package org.cft_latest.save.strategy;

import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationArgs;
import org.cft_latest.dto.ApplicationFile;
import org.cft_latest.save.FileSavingStrategy;
import org.cft_latest.save.UtilPatchProcessing;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseStrategy implements FileSavingStrategy {
    private final UtilPatchProcessing utilPatchProcessing;

    protected abstract List<String> getData(ApplicationFile file);

    protected abstract String fileName();

    @Override
    public void save(ApplicationFile file, ApplicationArgs args) {
        List<String> data = getData(file);
        if (data.isEmpty()) {
            return;
        }

        Path savePath = utilPatchProcessing.convertPath(args);
        savePath = utilPatchProcessing.createSavePath(args, savePath, fileName());

        try {
            StandardOpenOption[] options = args.isAppend() ?
                    new StandardOpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.APPEND} :
                    new StandardOpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING};

            try (BufferedWriter writer = Files.newBufferedWriter(savePath, options)) {
                for (String line : data) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка сохранения файла: " + e.getMessage() + " в " + this.getClass().getSimpleName());
        }
    }
}
