package ru.zhigalov.superkassa.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.zhigalov.superkassa.dto.request.ExampleUpdateRq;
import ru.zhigalov.superkassa.dto.response.ExampleUpdateRs;
import ru.zhigalov.superkassa.service.ExampleService;

@RestController
public class SuperController {

    private final ExampleService exampleService;

    public SuperController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping("/modify")
    public ResponseEntity<ExampleUpdateRs> updateObjById(@RequestBody ExampleUpdateRq rq) {
        var current = exampleService.updateObjById(rq.id(), rq.add());
        return ResponseEntity.ok(new ExampleUpdateRs(current));
    }
}
