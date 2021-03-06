package com.example.security.web.controller;

import com.example.security.model.Stuff;
import com.example.security.service.MyService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    MyService myService;
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/stuff/{myId}")
    public Stuff getById(@PathVariable final Integer myId) {
        return myService.getStuffById(myId);
    }

    @GetMapping("/stuff/all")
    public Iterable<Stuff> getAllStuff() {
        return myService.getAllStuff();
    }

    @DeleteMapping("/stuff")
    public Boolean deleteStuff() {
        myService.deleteAll();
        return true;
    }

    @PostMapping("/stuff")
    public void add(@RequestBody Stuff stuff) {
        stuff.updateHash();
        myService.add(stuff);
    }

}
