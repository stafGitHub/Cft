package org.cft_latest.repository.argumentRepo.Operation;

import org.cft_latest.dto.ApplicationArgs;
import org.cft_latest.repository.argumentRepo.ArgsEnum;
import org.cft_latest.repository.argumentRepo.ArgumentOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * ArgumentAddPath - операция отвечает за добавление пути сохранения
 */
@Component
public class ArgumentAddPath implements ArgumentOperation<Map<String, Object>, ApplicationArgs.ApplicationArgsBuilder> {

    @Override
    public void execute(@Autowired Map<String, Object> argMap,
                        ApplicationArgs.ApplicationArgsBuilder object) {
        String path = Optional.ofNullable(argMap.get(ArgsEnum.getName(ArgsEnum.o))).isPresent() ?
                argMap.get(ArgsEnum.getName(ArgsEnum.o)).toString() : ".";

        object.savePath(path);
    }

}
