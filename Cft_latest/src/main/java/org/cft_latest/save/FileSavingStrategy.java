package org.cft_latest.save;

import org.cft_latest.dto.ApplicationArgs;
import org.cft_latest.dto.ApplicationFile;

public interface FileSavingStrategy {
    void save(ApplicationFile file , ApplicationArgs args);
}
