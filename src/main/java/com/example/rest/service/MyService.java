package com.example.rest.service;

import com.example.rest.model.Stuff;

import java.util.Collection;

public interface MyService {

    public Collection<Stuff> getAllStuff();

    public Stuff getStuffById(String id);

    public void add(Stuff stuff);
}
