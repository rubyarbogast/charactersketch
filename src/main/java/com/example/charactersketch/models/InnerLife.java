package com.example.charactersketch.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class InnerLife extends Trait {

    private String fears;

    private String hopes;

    private String secretsFromOthers;

    private String secretsFromSelf;

    public InnerLife() {
    }

    public InnerLife(String fears, String hopes, String secretsFromOthers, String secretsFromSelf) {
        this.fears = fears;
        this.hopes = hopes;
        this.secretsFromOthers = secretsFromOthers;
        this.secretsFromSelf = secretsFromSelf;
    }

    public String getFears() {
        return fears;
    }

    public void setFears(String fears) {
        this.fears = fears;
    }

    public String getHopes() {
        return hopes;
    }

    public void setHopes(String hopes) {
        this.hopes = hopes;
    }

    public String getSecretsFromOthers() {
        return secretsFromOthers;
    }

    public void setSecretsFromOthers(String secretsFromOthers) {
        this.secretsFromOthers = secretsFromOthers;
    }

    public String getSecretsFromSelf() {
        return secretsFromSelf;
    }

    public void setSecretsFromSelf(String secretsFromSelf) {
        this.secretsFromSelf = secretsFromSelf;
    }
}
