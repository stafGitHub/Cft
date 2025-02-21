package org.cft_latest.repository.argumentRepo.Operation;

import org.cft_latest.dto.ApplicationArgs;
import org.cft_latest.repository.argumentRepo.ArgsEnum;
import org.cft_latest.repository.argumentRepo.ArgumentOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 *  ArgumentAddFullSave - операция отвечает за добавление атрибута полной статистики
 */
@Component
public class ArgumentAddFullSave implements ArgumentOperation<Map<String, Object>, ApplicationArgs.ApplicationArgsBuilder> {

    @Override
    public void execute(@Autowired Map<String, Object> argMap,
                        ApplicationArgs.ApplicationArgsBuilder object) {
        boolean fullS = Optional.ofNullable(argMap.get(ArgsEnum.getName(ArgsEnum.f))).isPresent();


        object.fullStatistics(fullS);
    }

}
