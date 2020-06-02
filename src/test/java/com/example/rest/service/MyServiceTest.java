package com.example.rest.service;

import com.example.rest.model.Stuff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyServiceTest {

    @Test
    public void testIdIsAdded() {
        MyService service = new MyServiceImpl();
        service.add(new Stuff("testid1", "Testid1Value"));
        Stuff testid1 = service.getStuffById("testid1");
        assertEquals(152438620, testid1.hash);
    }
}
