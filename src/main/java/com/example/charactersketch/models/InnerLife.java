package com.example.charactersketch.models;

public class InnerLife extends Trait {

    private String fears;

    private String hopes;

    private String secretsFromOthers;

    private String secretsFromSelf;

    public InnerLife() {
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
