package org.cft_latest.repository.argumentRepo.Operation;

import org.cft_latest.dto.ApplicationArgs;
import org.cft_latest.repository.argumentRepo.ArgsEnum;
import org.cft_latest.repository.argumentRepo.ArgumentOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

/**
 *  ArgumentAddFilePath - операция отвечает за добавление путей к файлам
 */
@Component
public class ArgumentAddFilePath implements ArgumentOperation<Map<String, Object> , ApplicationArgs.ApplicationArgsBuilder> {

    @Override
    public void execute(@Autowired Map<String, Object> argMap,
                        ApplicationArgs.ApplicationArgsBuilder object) {
        List<String> listFilePath = (List<String>) argMap.get(ArgsEnum.getName(ArgsEnum.fp));
        object.filePath(listFilePath);
    }

}
