package com.example.security.model;

public class Stuff {
    private Integer id;
    private String description;
    private String owner;
    private int hash;

    public Stuff() {}

    public Stuff(Integer id, String description, String owner) {
        this.id = id;
        this.description = description;
        this.owner = owner;
        this.hash = calcHash();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getOwner() {
        return owner;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHash() {
        return hash;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public int calcHash() {
        return String.format("%s - %s - %s", id, description, owner).hashCode();
    }

    public void updateHash() {
        if (getHash()==0) {
            setHash(calcHash());
        }
    }
}
