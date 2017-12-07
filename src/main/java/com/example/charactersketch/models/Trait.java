package com.example.charactersketch.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Trait {

    //not sure if this will work
    @Id
    @GeneratedValue
    private int id;

    public Trait() {
    }

    public Trait(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
