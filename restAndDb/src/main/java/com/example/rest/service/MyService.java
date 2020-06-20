package com.example.rest.service;

import com.example.rest.model.Stuff;

public interface MyService {

    Iterable<Stuff> getAllStuff();

    Stuff getStuffById(Integer id);

    void add(Stuff stuff);

    void deleteAll();
}
