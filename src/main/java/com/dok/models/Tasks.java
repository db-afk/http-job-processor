package com.dok.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

@JsonTypeName("tasks")
public class Tasks {

    private List<Task> tasks;

    public Tasks() {
        tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @JsonIgnore
    public void addTask(Task task) {
        tasks.add(task);
    }

    @JsonIgnore
    public Task getTask(String name) {
        return getTasks()
                .stream()
                .filter(task -> task.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
