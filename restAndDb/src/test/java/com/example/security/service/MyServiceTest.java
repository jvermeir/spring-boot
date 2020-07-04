package com.example.security.service;

import com.example.security.model.Stuff;
import com.example.security.repo.StuffRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testHashIsCalculated() {
        StuffRepository stuffRepository = mock(StuffRepository.class);
        when(stuffRepository.getById(1)).thenReturn(new Stuff(1, "Testid1Value"));
        Stuff stuff1 = stuffRepository.getById(1);
        assertEquals(-1156805585, stuff1.getHash());
    }

}
