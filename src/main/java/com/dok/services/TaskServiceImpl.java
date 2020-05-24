package com.dok.services;

import com.dok.models.Task;
import com.dok.models.Tasks;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

@Service
public class TaskServiceImpl implements TaskService {

    private String bash;
    private Tasks tasks;

    @Override
    public Tasks processJson(Tasks tasks) {
        // TODO: sort
        this.tasks = tasks;
        return this.tasks;
    }

    @Override
    public String processBash(Tasks tasks) {
        // TODO: sort
        StringJoiner joiner = new StringJoiner("", "#!/usr/bin/env bash", "");
        for (Task task : tasks.getTasks()) {
            joiner.add("\n");
            joiner.add(task.getCommand());
        }

        bash = joiner.toString();

        return bash;
    }

    @Override
    public Tasks getJson() {
        return tasks;
    }

    @Override
    public String getBash() {
        return bash;
    }
}
