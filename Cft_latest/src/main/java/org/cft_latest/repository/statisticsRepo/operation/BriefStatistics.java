package org.cft_latest.repository.statisticsRepo.operation;

import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationFile;
import org.cft_latest.repository.statisticsRepo.OperationStatistic;
import org.cft_latest.repository.statisticsRepo.UtilStatistics;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * BriefStatistics - краткая статистика
 */
@Component("briefStatistics")
@RequiredArgsConstructor
public class BriefStatistics implements OperationStatistic<ApplicationFile> {
    protected final UtilStatistics utilStatistics;

    @Override
    public void statistic(ApplicationFile input) {

        List<String> listAllElement = new ArrayList<>();
        listAllElement.addAll(input.getIntegers());
        listAllElement.addAll(input.getStrings());
        listAllElement.addAll(input.getFloats());

        int element = utilStatistics.countSymbol(listAllElement);

        utilStatistics.systemPrint(element);
    }
}
