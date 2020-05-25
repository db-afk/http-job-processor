package com.dok.controllers;

import com.dok.models.Tasks;
import com.dok.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService<Tasks> taskServiceJson;

    @Autowired
    private TaskService<String> taskServiceBash;

    @PostMapping(headers = {"Accept=application/json"},
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tasks> processJson(@RequestBody Tasks tasks) {
        return taskServiceJson.process(tasks);
    }

    @PostMapping(headers = {"Accept=application/json", "x-api-version=2"},
            produces = MediaType.TEXT_PLAIN_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> processBash(@RequestBody Tasks tasks) {
        return taskServiceBash.process(tasks);
    }
}
