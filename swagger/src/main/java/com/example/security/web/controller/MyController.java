package com.example.security.web.controller;

import com.example.security.model.Stuff;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {

    Map<Integer, Stuff> myStuff = new HashMap<>();

    public MyController() {
        myStuff.put(1, new Stuff(1, "one"));
        myStuff.put(2, new Stuff(2, "two"));
        myStuff.put(3, new Stuff(3, "three"));
    }

    @GetMapping("/stuff/{myId}")
    public Stuff getById(@PathVariable final Integer myId) {
        return myStuff.get(myId);
    }

    @GetMapping("/stuff/all")
    public Iterable<Stuff> getAllStuff() {
        return myStuff.values();
    }

    @PostMapping("/stuff")
    public Stuff add(@RequestBody Stuff stuff) {
        stuff.updateHash();
        myStuff.put(stuff.getId(), stuff);
        return stuff;
    }

}
