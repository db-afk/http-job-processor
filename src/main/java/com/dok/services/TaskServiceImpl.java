package com.dok.services;

import com.dok.models.Task;
import com.dok.models.Tasks;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.StringJoiner;

@Service
public class TaskServiceImpl implements TaskService {

    private String bash;
    private Tasks tasks;

    @Override
    public ResponseEntity<Tasks> processJson(Tasks tasks) {
        this.tasks = TaskSort.sort(tasks);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        return new ResponseEntity<>(this.tasks, map, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> processBash(Tasks tasks) {
        this.tasks = TaskSort.sort(tasks);
        StringJoiner joiner = new StringJoiner("", "#!/usr/bin/env bash", "");
        for (Task task : this.tasks.getTasks()) {
            joiner.add("\n");
            joiner.add(task.getCommand());
        }

        bash = joiner.toString();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.set(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
        return new ResponseEntity<>(bash, map, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Tasks> getJson() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        return new ResponseEntity<>(tasks, map, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getBash() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.set(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
        return new ResponseEntity<>(bash, map, HttpStatus.OK);
    }
}
