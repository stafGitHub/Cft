package org.cft_latest.repository.argumentRepo.Operation;

import org.cft_latest.dto.ApplicationArgs;
import org.cft_latest.repository.argumentRepo.ArgsEnum;
import org.cft_latest.repository.argumentRepo.ArgumentOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * ArgumentAddSaveTextFile - отвечает за добавление атрибута добавление текста к файлу
 */
@Component
public class ArgumentAddSaveTextFile implements ArgumentOperation<Map<String, Object>, ApplicationArgs.ApplicationArgsBuilder> {

    @Override
    public void execute(@Autowired Map<String, Object> argMap,
                        ApplicationArgs.ApplicationArgsBuilder object) {
        boolean add = Optional.ofNullable(argMap.get(ArgsEnum.getName(ArgsEnum.a))).isPresent();


        object.append(add);
    }

}
