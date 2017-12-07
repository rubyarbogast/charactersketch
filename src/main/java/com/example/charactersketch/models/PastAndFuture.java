package com.example.charactersketch.models;

import java.util.List;

public class PastAndFuture extends Trait {

    private String education;

    private List<String> goals;

    private String currentJob;

    private List<String> pastJobs;

    private String dreamJob;

    public PastAndFuture() {
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<String> getGoals() {
        return goals;
    }

    public void setGoals(List<String> goals) {
        this.goals = goals;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    public List<String> getPastJobs() {
        return pastJobs;
    }

    public void setPastJobs(List<String> pastJobs) {
        this.pastJobs = pastJobs;
    }

    public String getDreamJob() {
        return dreamJob;
    }

    public void setDreamJob(String dreamJob) {
        this.dreamJob = dreamJob;
    }
}
