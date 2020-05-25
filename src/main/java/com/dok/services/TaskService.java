package com.dok.services;

import com.dok.models.Tasks;
import org.springframework.http.ResponseEntity;

public interface TaskService<T> {

    ResponseEntity<T> process(Tasks tasks);
}
