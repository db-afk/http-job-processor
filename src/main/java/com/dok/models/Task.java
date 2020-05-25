package com.dok.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonTypeName("task")
public class Task {

    private String name;
    private String command;
    private List<String> requires;

    public Task() {
        requires = new ArrayList<>();
    }

    @JsonGetter
    public String getName() {
        return name;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter
    public String getCommand() {
        return command;
    }

    @JsonSetter
    public void setCommand(String command) {
        this.command = command;
    }

    @JsonIgnore
    public List<String> getRequires() {
        return requires;
    }

    @JsonSetter
    public void setRequires(List<String> requires) {
        this.requires = requires;
    }

    @JsonIgnore
    public boolean isValid() {
        return name != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) &&
                Objects.equals(command, task.command) &&
                Objects.equals(requires, task.requires);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, command, requires);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", command='" + command + '\'' +
                ", requires=" + requires +
                '}';
    }
}
