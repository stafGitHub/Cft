package org.cft_latest.repository.statisticsRepo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UtilStatistics {
    public List<Double> StringConvertDouble(List<String> listNumber) {
        return listNumber.stream()
                .map(Double::parseDouble)
                .toList();
    }

    public int maxLine(List<String> listLine) {
        int maxLine = listLine.get(0).length();

        for (String s : listLine) {
            if (s.length() > maxLine) {
                maxLine = s.length();
            }
        }

        return maxLine;
    }

    public int minLine(List<String> listLine) {
        int minLine = listLine.get(0).length();

        for (String s : listLine) {
            if (minLine > s.length()) {
                minLine = s.length();
            }
        }

        return minLine;
    }

    public double minNumber(List<Double> numbersDouble) {
        double min = numbersDouble.get(0);
        for (Double number : numbersDouble) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public double maxNumber(List<Double> numbersDouble) {
        double max = numbersDouble.get(0);
        for (Double number : numbersDouble) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public double sumNumber(List<Double> numbersDouble) {
        double sum = 0;
        for (Double number : numbersDouble) {
            sum += number;
        }
        return sum;
    }

    public double sumOverage(List<Double> numbersDouble,
                             double sum) {
        return sum / numbersDouble.size();
    }

    public void systemPrint(Object min,
                            Object max,
                            Object sum,
                            Object overage,
                            Object listLineSize,
                            Object maxLine,
                            Object minLine) {

        System.out.printf("""
                 _______________________________________________________________________________________
                 |  (min)              |    Минимальное значение        : %s
                 |  (max)              |    Максимальное значение       : %s
                 |  (sum)              |    Сумма                       : %s
                 |  (average)          |    Среднее арифметическое      : %s
                 |  (StringSize)       |    Количество строк            : %s
                 |  (StringMaxLength)  |    Максимальная длинна строки  : %s
                 |  (StringMinLength)  |    Минимальная длинна строки   : %s
                 ---------------------------------------------------------------------------------------
                
                """.formatted(min, max, sum, overage, listLineSize, maxLine, minLine));
    }

    public void systemPrint(Object countSymbol){
        System.out.printf("""
                    Количество элементов записанных в файлы -----> %s
                """.formatted(countSymbol));
    }

    public int countSymbol(List<String> listAllElement){
        AtomicInteger element = new AtomicInteger();
        listAllElement.forEach(line->{
            element.addAndGet(line.length());
        });
        return element.get();
    }
}
