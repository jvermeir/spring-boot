package com.example.rest.service;

import com.example.rest.model.Stuff;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class MyServiceImpl implements MyService {
    private final Map<String, Stuff> allStuff;
    public MyServiceImpl() {
        allStuff = new HashMap<>();
        allStuff.put("id1", new Stuff("id1", "id1Value"));
        allStuff.put("id2", new Stuff("id2", "id2Value"));
    }

    @Override
    public Collection<Stuff> getAllStuff() {
        Collection<Stuff> values = allStuff.values();
        return values;
    }

    @Override
    public Stuff getStuffById(String id) {
        return allStuff.get(id);
    }

    @Override
    public void add(Stuff stuff) {
        allStuff.put(stuff.id, stuff);
    }
}
