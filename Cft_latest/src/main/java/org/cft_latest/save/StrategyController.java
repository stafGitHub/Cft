package org.cft_latest.save;

import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationArgs;
import org.cft_latest.dto.ApplicationFile;
import org.cft_latest.save.strategy.BaseStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class StrategyController {
    private final Map<String, BaseStrategy> strategies;

    public void execute(String strategy,
                        ApplicationFile file,
                        ApplicationArgs args) {

        strategies.get(strategy).save(file, args);
    }
}
