package com.pragma.powerup.usermicroservice.domain.model;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void testGetters() {
        User user = new User(1L,"John", "Doe", "12345678A",
                "123456789", new Date(90,1,1), "john.doe@example.com",
                "password123", new Role(1L, "ADMIN","ADMIN"));

        assertEquals(1L, user.getId());
        assertEquals("John", user.getName());
        assertEquals("Doe", user.getSurname());
        assertEquals("john.doe@example.com", user.getMail());
        assertEquals("123456789", user.getPhone());
        assertEquals("12345678A", user.getDniNumber());
        assertEquals("password123", user.getPassword());
        assertEquals(new Date(90,1,1), user.getBirthdate());
        assertEquals(1L, user.getRole().getId());
        assertEquals("ADMIN", user.getRole().getName());
        assertEquals("ADMIN", user.getRole().getDescription());
    }

    @Test
    void testSetters() {
        User user = new User();
        user.setId(1L);
        user.setName("John");
        user.setSurname("Doe");
        user.setMail("john.doe@example.com");
        user.setPhone("123456789");
        user.setDniNumber("12345678A");
        user.setPassword("password123");
        user.setBirthdate(new Date(90,1,1));
        user.setRole(new Role(1L, "ADMIN","ADMIN"));

        assertEquals(1L, user.getId());
        assertEquals("John", user.getName());
        assertEquals("Doe", user.getSurname());
        assertEquals("john.doe@example.com", user.getMail());
        assertEquals("123456789", user.getPhone());
        assertEquals("12345678A", user.getDniNumber());
        assertEquals("password123", user.getPassword());
        assertEquals(new Date(90,1,1), user.getBirthdate());
        assertEquals(1L, user.getRole().getId());
        assertEquals("ADMIN", user.getRole().getName());
        assertEquals("ADMIN", user.getRole().getDescription());
    }
}