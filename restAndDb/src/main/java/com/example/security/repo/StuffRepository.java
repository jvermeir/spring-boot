package com.example.security.repo;

import com.example.security.model.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuffRepository extends JpaRepository<Stuff, Integer> {
    Stuff getById(Integer id);
}
