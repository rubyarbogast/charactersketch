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
}
