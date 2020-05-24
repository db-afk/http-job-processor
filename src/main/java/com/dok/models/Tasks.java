package com.dok.models;

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
}
