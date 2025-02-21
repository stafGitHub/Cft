package org.cft_latest.service;

import lombok.RequiredArgsConstructor;
import org.cft_latest.dto.ApplicationArgs;
import org.cft_latest.repository.argumentRepo.ArgumentOperationRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ArgumentService {
    private final ArgumentOperationRepository argumentOperationRepository;

    public ApplicationArgs.ApplicationArgsBuilder createApplicationArgs(Map<String, Object> argMap) {
        ApplicationArgs.ApplicationArgsBuilder applicationArgsBuilder = ApplicationArgs.builder();
        return argumentOperationRepository.execute(argMap,applicationArgsBuilder);
    }
}
