package com.dok.services;

import com.dok.models.Tasks;
import org.springframework.http.ResponseEntity;

public interface TaskService {

    ResponseEntity<Tasks> processJson(Tasks tasks);

    ResponseEntity<String> processBash(Tasks tasks);

    ResponseEntity<Tasks> getJson();

    ResponseEntity<String> getBash();
}
