package org.cft_latest.save.strategy;

import org.cft_latest.dto.ApplicationFile;
import org.cft_latest.save.EnumSaveFileName;
import org.cft_latest.save.UtilPatchProcessing;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("strings")
public class StringSaveFile extends BaseStrategy {
    public StringSaveFile(UtilPatchProcessing utilPatchProcessing) {
        super(utilPatchProcessing);
    }

    @Override
    protected List<String> getData(ApplicationFile file) {
        return file.getStrings();
    }

    @Override
    protected String fileName() {
        return EnumSaveFileName.getFileName(EnumSaveFileName.strings);
    }
}
