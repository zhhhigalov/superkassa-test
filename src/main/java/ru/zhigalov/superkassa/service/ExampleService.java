package ru.zhigalov.superkassa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.zhigalov.superkassa.repository.ExampleRepository;

@Service
public class ExampleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleService.class);
    private final ExampleRepository exampleRepository;

    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public int updateObjById(int id, int add) {
        var current = exampleRepository.updateObjById(id, add);
        LOGGER.info("Object with id = {} updated, current value = {}", id, current);
        return current;
    }
}
