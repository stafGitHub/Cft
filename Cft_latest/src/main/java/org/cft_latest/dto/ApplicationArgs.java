package org.cft_latest.dto;

import lombok.*;

import java.util.List;

/**
 * ApplicationArgs - класс с данными приложения
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationArgs {
    //-o сохранение файла в директорию
    private String savePath ;
    //-p префикс для сохранения файлов
    private String prefix ;
    //-a режим добавления
    private boolean append;
    //-s краткая статистика
    private boolean briefStatistics;
    //-f полная статистика
    private boolean fullStatistics;
    //-fp путь к файлу
    private List<String> filePath ;

}
