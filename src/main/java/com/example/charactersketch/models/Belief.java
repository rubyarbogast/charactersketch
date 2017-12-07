package com.example.charactersketch.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Belief extends InnerLife {

    private String political;

    private String religious;

    private String aboutSelf;

    public Belief() {
    }

    public Belief(String political, String religious, String aboutSelf) {
        this.political = political;
        this.religious = religious;
        this.aboutSelf = aboutSelf;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getReligious() {
        return religious;
    }

    public void setReligious(String religious) {
        this.religious = religious;
    }

    public String getAboutSelf() {
        return aboutSelf;
    }

    public void setAboutSelf(String aboutSelf) {
        this.aboutSelf = aboutSelf;
    }
}
