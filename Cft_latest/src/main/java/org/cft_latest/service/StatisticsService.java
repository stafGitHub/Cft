package org.cft_latest.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationArgs;
import org.cft_latest.dto.ApplicationFile;
import org.cft_latest.repository.statisticsRepo.NameStatisticsEnum;
import org.cft_latest.repository.statisticsRepo.StatisticOperationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {
    private final StatisticOperationRepository statisticOperationRepository;
    private final ApplicationFile applicationFile;
    private final ApplicationArgs applicationArgs;

    @PostConstruct
    public void briefStatistics() {
        if (applicationArgs.isBriefStatistics()) {
            statisticOperationRepository.execute(
                    NameStatisticsEnum.briefStatistics.name(),
                    applicationFile
            );
        }
    }
    @PostConstruct
    public void fullStatistics() {
        if (applicationArgs.isFullStatistics()) {
            statisticOperationRepository.execute(
                    NameStatisticsEnum.fullStatistics.name(),
                    applicationFile
            );
        }
    }
}
