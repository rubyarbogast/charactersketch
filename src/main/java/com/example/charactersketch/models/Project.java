package com.example.charactersketch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Project {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String title;
}
