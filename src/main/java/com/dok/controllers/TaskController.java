package com.dok.controllers;

import com.dok.models.Tasks;
import com.dok.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public Tasks getJson() {
        return taskService.getJson();
    }

    @PostMapping(headers = {"Accept=application/json"},
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Tasks processJson(@RequestBody Tasks tasks) {
        return taskService.processJson(tasks);
    }

    @GetMapping(headers = {"x-api-version=2"})
    public String getBash() {
        return taskService.getBash();
    }

    @PostMapping(headers = {"Accept=application/json", "x-api-version=2"},
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String processBash(@RequestBody Tasks tasks) {
        return taskService.processBash(tasks);
    }
}