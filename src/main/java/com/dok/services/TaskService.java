package com.dok.services;

import com.dok.models.Tasks;
import org.springframework.http.ResponseEntity;

public interface TaskService<Т> {

    ResponseEntity<Т> process(Tasks tasks);

    ResponseEntity<Т> get();
}
