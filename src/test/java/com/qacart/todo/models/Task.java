package com.qacart.todo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {

    private boolean isCompleted;
    private String item;

    public Task(boolean isCompleted, String item) {
        this.isCompleted = isCompleted;
        this.item = item;
    }

    @JsonProperty("isCompleted")
    public boolean isCompleted() {
        return isCompleted;
    }

    @JsonProperty("isCompleted")
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
