package org.cft_latest.repository.argumentRepo.Operation;

import org.cft_latest.dto.ApplicationArgs;
import org.cft_latest.repository.argumentRepo.ArgsEnum;
import org.cft_latest.repository.argumentRepo.ArgumentOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * ArgumentAddPrefix - отвечает за добавление префикса к сохраняемым файлам
 */
@Component
public class ArgumentAddPrefix implements ArgumentOperation<Map<String, Object>, ApplicationArgs.ApplicationArgsBuilder> {

    @Override
    public void execute(@Autowired Map<String, Object> argMap,
                        ApplicationArgs.ApplicationArgsBuilder object) {
        String prefix = Optional.ofNullable(argMap.get(ArgsEnum.getName(ArgsEnum.p))).isPresent() ? argMap.get(ArgsEnum.getName(ArgsEnum.p)).toString() : "";


        object.prefix(prefix);
    }

}
