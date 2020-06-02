package com.example.rest.web.controller;

import com.example.rest.model.Stuff;
import com.example.rest.service.MyService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MyController {

    MyService myService;
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/stuff/{myId}")
    public Stuff getById(@PathVariable final String myId) {
        return myService.getStuffById(myId);
    }

    @GetMapping("/stuff/all")
    public Collection<Stuff>  getAllStuff() {
        return myService.getAllStuff();
    }

    @PostMapping("/stuff")
    public void add(@RequestBody Stuff stuff) {
        myService.add(stuff);
    }

}
