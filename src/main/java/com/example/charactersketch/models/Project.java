package com.example.charactersketch.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String title;

    @ManyToOne
    private User creator;

    public Project(int id) {
        this.id = id;
    }

    public Project() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
