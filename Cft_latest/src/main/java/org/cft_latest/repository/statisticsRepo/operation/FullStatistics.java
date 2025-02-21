package org.cft_latest.repository.statisticsRepo.operation;

import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationFile;
import org.cft_latest.repository.statisticsRepo.OperationStatistic;
import org.cft_latest.repository.statisticsRepo.UtilStatistics;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * FullStatistics - полная статистика
 */
@Component
public class FullStatistics extends BriefStatistics implements OperationStatistic<ApplicationFile> {
    public FullStatistics(UtilStatistics utilStatistics) {
        super(utilStatistics);
    }

    @Override
    public void statistic(ApplicationFile input) {
        super.statistic(input);
        List<String> listLine = input.getStrings();

        List<String> numbers = new ArrayList<>();
        numbers.addAll(input.getFloats());
        numbers.addAll(input.getIntegers());

        if (numbers.isEmpty()) {
            System.out.println("Числа не войдут в полную статистику , так как их нет");
            return;
        }

        List<Double> numbersDouble = utilStatistics.StringConvertDouble(numbers);

        int maxLine = utilStatistics.maxLine(listLine);
        int minLine = utilStatistics.minLine(listLine);

        double min = utilStatistics.minNumber(numbersDouble);
        double max = utilStatistics.maxNumber(numbersDouble);
        double sum = utilStatistics.sumNumber(numbersDouble);
        double overage = utilStatistics.sumOverage(numbersDouble, sum);

       utilStatistics.systemPrint(min,max,sum,overage,listLine.size(),maxLine,minLine);
    }
}