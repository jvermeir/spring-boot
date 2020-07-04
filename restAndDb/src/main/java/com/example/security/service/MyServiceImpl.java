package com.example.security.service;

import com.example.security.model.Stuff;
import com.example.security.repo.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    @Autowired
    private StuffRepository stuffRepository;

    public MyServiceImpl(StuffRepository stuffRepository) {
        this.stuffRepository = stuffRepository;
    }

    @Override
    public Iterable<Stuff> getAllStuff() {
        return stuffRepository.findAll();
    }

    @Override
    public Stuff getStuffById(Integer id) {
        return stuffRepository.getById(id);
    }

    @Override
    public void add(Stuff stuff) {
        stuffRepository.save(stuff);
    }

    @Override
    public void deleteAll() {
        stuffRepository.deleteAll();
    }
}
