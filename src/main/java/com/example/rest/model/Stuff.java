package com.example.rest.model;

public class Stuff {
    public final String id;
    public final String description;
    public final int hash;

    public Stuff(String id, String description) {
        this.id = id;
        this.description = description;
        this.hash = String.format("%s - %s", id, description).hashCode();
    }

}
