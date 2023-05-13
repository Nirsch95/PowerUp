package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserRequestDtoTest {
    @Test
    void testGetters() {
        UserRequestDto userRequestDto = new UserRequestDto("John", "Doe", "12345678A",
                "123456789", new Date(90,1,1), "john.doe@example.com",
                "password123", 1L);

        assertEquals("John", userRequestDto.getName());
        assertEquals("Doe", userRequestDto.getSurname());
        assertEquals("john.doe@example.com", userRequestDto.getMail());
        assertEquals("123456789", userRequestDto.getPhone());
        assertEquals("12345678A", userRequestDto.getDniNumber());
        assertEquals("password123", userRequestDto.getPassword());
        assertEquals(new Date(90,1,1), userRequestDto.getBirthdate());
        assertEquals(1L, userRequestDto.getIdRole());
    }
}