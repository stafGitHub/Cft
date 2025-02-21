package org.cft_latest.applicationData.applicationArguments;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * ArgumentParser - компонент , отвечающий за парсинг данных из командной строки
 */
@Component
public class ArgumentParser {
    public Map<String, Object> argumentConfigure(ApplicationArguments input) {
        Map<String, Object> argMap = new HashMap<>();

        for (String arg : input.getNonOptionArgs()) {
            if (arg.startsWith("-")) {
                String[] parts = arg.split("::");
                String key = parts[0];
                Object value = true;

                if (key.equals("-fp")){
                    List<String> strings = new ArrayList<>(List.of(parts[1].split(",")));
                    argMap.put(key, strings);
                    continue;
                }

                if (parts.length > 1) {
                    value = parts[1];
                }

                argMap.put(key, value);
            }
        }
        return argMap;
    }
}
