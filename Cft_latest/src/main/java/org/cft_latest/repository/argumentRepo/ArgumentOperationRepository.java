package org.cft_latest.repository.argumentRepo;

import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationArgs;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ArgumentOperationRepository {
    private final List<ArgumentOperation> argumentOperations;


    public ApplicationArgs.ApplicationArgsBuilder execute(Map<String, Object> argMap,
                                                          ApplicationArgs.ApplicationArgsBuilder applicationArgsBuilder) {

        argumentOperations.forEach(argumentOperation -> argumentOperation.execute(argMap, applicationArgsBuilder));
        return applicationArgsBuilder;
    }

}
