package com.example.charactersketch.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Project {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String title;
}
