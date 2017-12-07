package com.example.charactersketch.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class DailyLife extends Trait {

    private String schedule;

    private String habits;

    private String hobbies;

    private String responsibilities;

    public DailyLife() {
    }

    public DailyLife(String schedule, String habits, String hobbies, String responsibilities) {
        this.schedule = schedule;
        this.habits = habits;
        this.hobbies = hobbies;
        this.responsibilities = responsibilities;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }
}
