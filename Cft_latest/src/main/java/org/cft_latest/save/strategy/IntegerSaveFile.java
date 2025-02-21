package org.cft_latest.save.strategy;

import org.cft_latest.dto.ApplicationFile;
import org.cft_latest.save.EnumSaveFileName;
import org.cft_latest.save.UtilPatchProcessing;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("integers")
public class IntegerSaveFile extends BaseStrategy {
    public IntegerSaveFile(UtilPatchProcessing utilPatchProcessing) {
        super(utilPatchProcessing);
    }

    @Override
    protected List<String> getData(ApplicationFile file) {
        return file.getIntegers();
    }

    @Override
    protected String fileName() {
        return EnumSaveFileName.getFileName(EnumSaveFileName.integers);
    }
}
