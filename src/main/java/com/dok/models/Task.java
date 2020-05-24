package com.dok.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

@JsonTypeName("task")
public class Task {

    @JsonProperty
    private String name;

    @JsonProperty
    private String command;

    @JsonProperty
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

    @JsonGetter
    public List<String> getRequires() {
        return requires;
    }

    @JsonSetter
    public void setRequires(List<String> requires) {
        this.requires = requires;
    }
}
