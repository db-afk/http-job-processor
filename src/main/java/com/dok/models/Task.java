package com.dok.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

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
}
