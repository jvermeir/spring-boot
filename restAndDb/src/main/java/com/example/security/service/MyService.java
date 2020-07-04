package com.example.security.service;

import com.example.security.model.Stuff;

public interface MyService {

    Iterable<Stuff> getAllStuff();

    Stuff getStuffById(Integer id);

    void add(Stuff stuff);

    void deleteAll();
}
