package com.dok.services;

import com.dok.models.Tasks;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class TaskServiceJson implements TaskService<Tasks> {

    private Tasks tasks;

    @Override
    public ResponseEntity<Tasks> process(Tasks tasks) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        if (!tasks.isValid()) {
            return new ResponseEntity<>(null, map, HttpStatus.BAD_REQUEST);
        }

        this.tasks = TaskSort.sort(tasks);
        return new ResponseEntity<>(this.tasks, map, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Tasks> get() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        return new ResponseEntity<>(tasks, map, HttpStatus.OK);
    }
}
