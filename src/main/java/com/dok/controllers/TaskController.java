package com.dok.controllers;

import com.dok.models.Tasks;
import com.dok.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<Tasks> getJson() {
        return taskService.getJson();
    }

    @PostMapping(headers = {"Accept=application/json"},
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tasks> processJson(@RequestBody Tasks tasks) {
        return taskService.processJson(tasks);
    }

    @GetMapping(headers = {"x-api-version=2"})
    public ResponseEntity<String> getBash() {
        return taskService.getBash();
    }

    @PostMapping(headers = {"Accept=application/json", "x-api-version=2"},
            produces = MediaType.TEXT_PLAIN_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> processBash(@RequestBody Tasks tasks) {
        return taskService.processBash(tasks);
    }
}
