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

import java.util.Objects;
import java.util.StringJoiner;

@Service
public class TaskServiceBash implements TaskService<String> {

    private String bash;

    @Override
    public ResponseEntity<String> process(Tasks tasks) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.set(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);

        if (!tasks.isValid()) {
            return new ResponseEntity<>("", map, HttpStatus.BAD_REQUEST);
        }

        StringJoiner joiner = new StringJoiner("", "#!/usr/bin/env bash", "");
        for (Task task : Objects.requireNonNull(TaskSort.sort(tasks)).getTaskList()) {
            joiner.add("\n");
            joiner.add(task.getCommand());
        }

        bash = joiner.toString();
        return new ResponseEntity<>(bash, map, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> get() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.set(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
        return new ResponseEntity<>(bash, map, HttpStatus.OK);
    }
}
