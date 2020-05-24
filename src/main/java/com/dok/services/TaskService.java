package com.dok.services;

import com.dok.models.Tasks;

public interface TaskService {

    Tasks processJson(Tasks tasks);

    String processBash(Tasks tasks);

    Tasks getJson();

    String getBash();
}
