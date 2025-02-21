package org.cft_latest.save;

import org.cft_latest.dto.ApplicationArgs;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class UtilPatchProcessing {

    public Path convertPath(ApplicationArgs args) {
        Path savePath = Paths.get(args.getSavePath());
        if (!savePath.isAbsolute()) {
            savePath = Path.of(Paths.get(args.getSavePath()).toUri());
        }
        return savePath;
    }

    public Path createSavePath(ApplicationArgs args,
                               Path savePath,
                               String name) {

        String fileName;
        if (!args.getPrefix().isEmpty()) {
            fileName = "\\" + args.getPrefix() + "_" + name;
        }else {
            fileName = "\\"+name;
        }
        savePath = Paths.get(savePath + fileName);

        return savePath;
    }
}
