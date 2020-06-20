package com.example.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stuff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    private int hash;

    public Stuff() {}

    public Stuff(Integer id, String description) {
        this.id = id;
        this.description = description;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public int calcHash() {
        return String.format("%s - %s", id, description).hashCode();
    }

    public void updateHash() {
        if (getHash()==0) {
            setHash(calcHash());
        }
    }
}
