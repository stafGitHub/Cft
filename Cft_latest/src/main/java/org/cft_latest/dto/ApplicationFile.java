package org.cft_latest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * ApplicationFile - класс с данными по всем файлам
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationFile {
    @Builder.Default
    List<String> strings = new ArrayList<>();
    @Builder.Default
    List<String> integers = new ArrayList<>();
    @Builder.Default
    List<String> floats = new ArrayList<>();

}
