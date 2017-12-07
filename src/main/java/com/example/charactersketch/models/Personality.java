package com.example.charactersketch.models;

import java.util.List;

public class Personality extends Trait {

    private List<String> tags;

    private String description;

    public Personality() {
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
