package com.example.charactersketch.models;

public class Relationships extends Trait {

    //some of these should be longer text type once figured out
    private String status;

    private String kids;

    private String parents;

    private String siblings;

    private String friendships;

    private String otherRelationships;

    public Relationships() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKids() {
        return kids;
    }

    public void setKids(String kids) {
        this.kids = kids;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public String getSiblings() {
        return siblings;
    }

    public void setSiblings(String siblings) {
        this.siblings = siblings;
    }

    public String getFriendships() {
        return friendships;
    }

    public void setFriendships(String friendships) {
        this.friendships = friendships;
    }

    public String getOtherRelationships() {
        return otherRelationships;
    }

    public void setOtherRelationships(String otherRelationships) {
        this.otherRelationships = otherRelationships;
    }
}
