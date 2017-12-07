package com.example.charactersketch.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Appearance extends Trait {

    private String height;

    private int weight;

    private String eyeColor;

    private String hairColor;

    private String hairTexture;

    private String skinColor;

    private String personalStyle;

    private String attractiveness;

    public Appearance() {
    }

    public Appearance(String height, int weight, String eyeColor, String hairColor, String hairTexture, String skinColor, String personalStyle, String attractiveness) {
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.hairTexture = hairTexture;
        this.skinColor = skinColor;
        this.personalStyle = personalStyle;
        this.attractiveness = attractiveness;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHairTexture() {
        return hairTexture;
    }

    public void setHairTexture(String hairTexture) {
        this.hairTexture = hairTexture;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getPersonalStyle() {
        return personalStyle;
    }

    public void setPersonalStyle(String personalStyle) {
        this.personalStyle = personalStyle;
    }

    public String getAttractiveness() {
        return attractiveness;
    }

    public void setAttractiveness(String attractiveness) {
        this.attractiveness = attractiveness;
    }
}
