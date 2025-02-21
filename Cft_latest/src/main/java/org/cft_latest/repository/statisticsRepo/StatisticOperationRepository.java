package org.cft_latest.repository.statisticsRepo;

import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationFile;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class StatisticOperationRepository {
    private final Map<String,OperationStatistic> statisticOperationRepositoryMap;

    public void execute(String operationName,
                        ApplicationFile file) {
        statisticOperationRepositoryMap.get(operationName).statistic(file);
    }
}
