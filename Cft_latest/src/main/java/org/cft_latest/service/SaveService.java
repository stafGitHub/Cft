package org.cft_latest.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationArgs;
import org.cft_latest.dto.ApplicationFile;
import org.cft_latest.save.EnumSaveFileName;
import org.cft_latest.save.StrategyController;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveService {
    private final ApplicationFile applicationFile;
    private final ApplicationArgs applicationArgs;
    private final StrategyController strategyController;

    @PostConstruct
    public void saveFileString(){
        strategyController.execute(
                EnumSaveFileName.strings.toString(),
                applicationFile,
                applicationArgs
        );
    }

    @PostConstruct
    public void saveFileInteger(){
        strategyController.execute(
                EnumSaveFileName.integers.toString(),
                applicationFile,
                applicationArgs
        );
    }
    @PostConstruct
    public void saveFileFloat(){
        strategyController.execute(
                EnumSaveFileName.floats.toString(),
                applicationFile,
                applicationArgs
        );
    }
}
