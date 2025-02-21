package org.cft_latest.repository.fileRepo;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
public class UtilFileReader {
    public boolean isString(String line) {
        try {
            Long.parseLong(line);
            return false;
        } catch (NumberFormatException e) {
            try {
                Double.parseDouble(line);
                return false;
            } catch (NumberFormatException e1) {
                return !line.isEmpty();
            }
        }
    }

    public boolean isFloat(String line) {
        try {
            if (line.contains(".")) {
                Double.parseDouble(line);
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isInteger(String line) {
        try {
            Long.parseLong(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void readFile(List<String> allLines,
                         List<File> input) {
        List<List<String>> fileLines = new ArrayList<>();
        for (File file : input) {
            try {
                fileLines.add(Files.readAllLines(Path.of(file.getPath())));
            } catch (IOException e) {
                System.err.println("Ошибка чтения файла: " + file.getPath());
                e.printStackTrace();
            }
        }

        int maxLines = fileLines.stream()
                .mapToInt(List::size)
                .max()
                .orElse(0);

        for (int i = 0; i < maxLines; i++) {
            for (List<String> lines : fileLines) {
                if (i < lines.size()) {
                    allLines.add(lines.get(i));
                }
            }
        }
    }
}
