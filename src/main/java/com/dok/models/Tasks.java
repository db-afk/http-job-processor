package com.dok.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

@JsonTypeName("tasks")
public class Tasks {

    private final List<Task> taskList;

    public Tasks() {
        taskList = new ArrayList<>();
    }

    @JsonGetter(value = "tasks")
    public List<Task> getTaskList() {
        return taskList;
    }

    @JsonIgnore
    public void addTask(Task task) {
        taskList.add(task);
    }

    @JsonIgnore
    public Task getTask(String name) {
        return getTaskList()
                .stream()
                .filter(task -> task.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @JsonIgnore
    public boolean isValid() {
        return !getTaskList().isEmpty() && getTaskList().stream().allMatch(Task::isValid);
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "tasks=" + taskList +
                '}';
    }
}
