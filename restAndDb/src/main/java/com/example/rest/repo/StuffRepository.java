package com.example.rest.repo;

import com.example.rest.model.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuffRepository extends JpaRepository<Stuff, Integer> {
    Stuff getById(Integer id);
}
